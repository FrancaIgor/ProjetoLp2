package item;

import easyaccept.EasyAccept;
/**
 * 
 * @author Victor Braga, Cleciana Santana
 * 		   Igor Franca, Rostanth
 */
public class Facade {

	/**
	 * Controller de Itens que podem ser comprados
	 */
	ControllerItens controllerDeItens = new ControllerItens();
	/**
	 * Controller de ListasDeCompras
	 */
	ControllerListaCompras controllerDeListas = new ControllerListaCompras();
	

	public static void main (String[] args) {
		args = new String[] {"item.Facade", "testes/use_case1.txt", "testes/use_case1_exception.txt", 
							 "testes/use_case4.txt"};
		EasyAccept.main(args);
	}
	
	/**
	 * Metodo que adiciona um item que se compra com uma quantidade fixa. Ex:
	 * Algodão branco 200g
	 * 
	 * @param nome
	 *            eh o nome do que descreve o produto
	 * @param categoria
	 *            que define sua finalidade Ex: No caso de algoda seria: higiene
	 *            pessoal
	 * @param qtd
	 *            um inteiro que diz a quantidade que esse produto contem
	 * @param unidadeDeMedida
	 *            unidade de medida usada por esse produto
	 * @param localDeCompra
	 *            Local onde o produto foi comprado
	 * @param preco
	 *            preco do item
	 * @return retorna o idNumerico desse produto
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qtd, String unidadeDeMedida, String localDeCompra, double preco) {
		return this.controllerDeItens.adicionaItemPorQtd(nome, categoria, qtd, unidadeDeMedida, localDeCompra, preco);
	}

	/**
	 * 
	 * Metodo que adiciona um item que se compra por peso. Ex: 200g de carne
	 * 
	 * @param nome
	 *            eh o nome do que descreve o produto
	 * @param categoria
	 *            que define sua finalidade Ex: 200g de picinha: Alimntos nao
	 *            industrializdos
	 * @param kg
	 *            um numero real que diz a quantidade que foi comprada desse produto
	 * @param localDeCompra
	 *            Local onde o produto foi comprado
	 * @param preco
	 *            preco do item
	 * @return retorna o int idNumerico que identifica o item.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return this.controllerDeItens.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	/**
	 * 
	 * Metodo que adiciona um item que se compra por unidade. Ex: 1 queijo minas.
	 * 
	 * @param nome
	 *            eh o nome do que descreve o produto
	 * @param categoria
	 *            que define sua finalidade Ex: 1 queijo minhas: Alimntos
	 *            industrializdos
	 * @param unidade
	 *            um numero inteiro que diz a quantidade de itens daquele que foi
	 *            comprada
	 * @param localDeCompra
	 *            Local onde o produto foi comprado
	 * @param preco
	 *            preco do item
	 * @return retorna o int idNumerico que identifica o item.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return this.controllerDeItens.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}

	/**
	 * Metodo que permite modificar os parametros de um item, exceto seu idNumerico
	 * 
	 * @param idNumerico
	 *            inteiro que identifica cada item e nao pode ser alterado
	 * @param atributo
	 *            string que leva o mesmo nome do atributo que se quer moficar
	 * @param novoValor
	 *            String que recebe a nova String que se quer alterar.
	 */
	public void atualizaItem(int idNumerico, String atributo, String novoValor) {
		this.controllerDeItens.atualizaItem(idNumerico, atributo, novoValor);
	}

	/**
	 * Metodo que apos cadastrar um item, permite que se atribua um preco a esse
	 * item e o associe a um local de compra esse metodo pode armazenar varios
	 * precos e seus respectivos locais de compra. Um mapa eh usado para armazenar
	 * estes dados.
	 * 
	 * @param idNumerico
	 *            int que identifica cada produto e eh imutavel
	 * @param localDeCompra
	 *            local onde o produto foi comprado com aquele determinado preco
	 * @param preco
	 *            preco do protudo no local de compra especificado
	 */
	public void adicionaPrecoItem(int idNumerico, String localDeCompra, double preco) {
		this.controllerDeItens.adicionaPrecoItem(idNumerico, localDeCompra, preco);
	}

	/**
	 * Metodo que recebe um inteiro idNumerico (que identifica cada item), e
	 * retorna a string que representa o item. Alem disso o metodo
	 * ordena a lista de itens por ordem alfabetica.
	 * 
	 * @return retorna a representacao do item indicado atraves do idnumerico.
	 */
	public String exibeItem(int idNumerico) {
		return this.controllerDeItens.exibeItem(idNumerico);
	}
	
	/**
	 * Metodo que recebe o idNumerico do item e atraves dele deleta-o do sistema.
	 * 
	 * @param idNumerico
	 *            int que intenfica cada item e eh imutavel.
	 */
	public void deletaItem(String idNumerico) {
		this.controllerDeItens.deletaItem(idNumerico);
	}

	/**
	 * Metodo que recebe um inteiro idNumerico (que identifica cada item), e
	 * atraves desse id retorna a string que representa o item. Alem disso o metodo
	 * ordena a lista de itens cadastrados por ordem alfabetica
	 * 
	 * @return retorna a representacao o item indicado atraves do idnumerico
	 */
	public Item getItem(int idNumerico) {
		return this.controllerDeItens.getItem(idNumerico);
	}
	
	/**
	 * Metodo que pesquisa e retorna um Item da categoria informada usando seu id.
	 * Caso o item nao exista retorna: "".
	 * 
	 * @param categoria
	 * @param posicao
	 * @return
	 * 			Retorna representacao String do Item.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return this.controllerDeItens.getItemPorCategoria(categoria, posicao);
	}
	
	public String getItemPorMenorPreco(int posicao) {
		return this.controllerDeItens.getItemPorMenorPreco(posicao);
	}
	
	/**
	 * Metodo que cria uma lista de compras recebendo sua descricao e adiciona essa
	 * lista à uma colecao de listas. Lanca uma excecao caso a descricao seja nula ou vazia.
	 */
	public String adicionaListaDeCompras(String descritor) {
		return this.controllerDeListas.adicionaListaDeCompras(descritor);
	}
	
	/**
	 * Método que retorna representacao String de uma compra caso esta esteja
	 * cadastrada na Lista
	 * 
	 * @param descricao
	 * 			Descricao da Lista que pode conter a compra
	 * @param idNumerico
	 * 			ID do Item desejado
	 * @return
	 * 			Retorna uma String representacao do Objeto Compra
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		return this.controllerDeListas.pesquisaListaDeCompras(descritorLista);
	}
	
	/**
	 * Adiciona uma compra a lista de compras, recebendo sua descricao, um
	 * objeto Item e a quantidade deste Item na lista. Lanca excecao se o item nao existe.
	 * 
	 * @param descricao
	 * 			Descricao da lista de compras
	 * @param quantidade
	 * 			Quantidade de Itens da compra
	 * @param item
	 * 			Item a ser comprado
	 */
	public void adicionaCompraALista(String descritor, int quantidade, int idItem) {
		Item item = this.controllerDeItens.getItem(idItem);
		this.controllerDeListas.adicionarCompraALista(descritor, quantidade, item);
	}
	
	/**
	 * Retorna representacao String de uma compra caso esta esteja cadastrada na Lista
	 * 
	 * @param descricao
	 * 			Descricao da Lista que pode conter a compra
	 * @param idNumerico
	 * 			ID do Item desejado
	 * @return
	 * 			Retorna uma String representacao do Objeto Compra
	 */
	public String pesquisaCompraEmLista(String descritor, int itemId) {
		return this.controllerDeListas.pesquisaCompraEmLista(descritor, itemId);
	}
	
	/**
	 * Metodo que atualiza a quantidade de itens de uma compra. Lanca excecao caso o item
	 * nao exista ou a operacao recebida seja invalida.
	 * 
	 * @param descritorLista
	 * 			Descritor da lista que contem a compra
	 * @param itemId
	 * 			Identificador do Item da compra
	 * @param operacao
	 * 			Operacao a ser efetuada na quantidade. Pode ser "adiciona" ou "diminui".
	 * @param quantidade
	 * 			Quantidade de Item a ser acrescida ou retirada da compra.
	 */
	public void atualizaCompraDeLista(String descritor, int itemId, String operacao, int quantidade) {
		this.controllerDeListas.atualizaCompraDeLista(descritor, itemId, operacao, quantidade);
	}
	
	/**
	 * Método que, quando o usuario realiza as compras, finaliza uma lista.
	 * 
	 * @param descricao
	 * 			Descricao da lista de compras
	 * @param localDeCompra
	 * 			Estabelecimento em que foram realizadas as compras
	 * @param valorFinal
	 * 			Valor Total de todas as compras feitas em um local
	 */
	public void finalizarListaDeCompras(String descritor, String localDaCompra, double valorFinalDaCompra) {
		this.controllerDeListas.finalizarListaDeCompras(descritor, localDaCompra, valorFinalDaCompra);
	}
	
	/**
	 * Retorna a String representacao de uma compra na lista. Caso a compra nao exista
	 * retorna uma String vazia.
	 * 
	 * @param descricao
	 * 			Descricao da lista de compras
	 * @param idItem
	 * 			Id do item associado a compra
	 */
	public void getItemLista(String descritor, int posicao) {
		this.controllerDeListas.pesquisaCompraEmLista(descritor, posicao);
	}
	/**
	 * Deleta, da Lista de compras, a que esta associada ao Item recebido.
	 * 
	 * @param descritorLista
	 * 			Descritor da Lista que contem a compra.
	 * @param itemId
	 * 			Identificador do Item associado a compra que sera remoivda.
	 */
	public void deletaCompraDeLista(String descritor, int itemId) {
		Item item = this.controllerDeItens.getItem(itemId);
		this.controllerDeListas.deletaCompraDeLista(descritor, item);
	}
	
	

}
