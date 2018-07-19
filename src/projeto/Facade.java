package projeto;

import easyaccept.EasyAccept;
/**
 * 
 * @author Victor Braga
 *
 */
public class Facade {

	ControllerItens novoController = new ControllerItens();
	ControllerListaCompras controllerCompras = new ControllerListaCompras();
	

	public static void main (String[] args) {
		args = new String[] {"projeto.Facade", "testes/use_case1.txt", "testes/use_case1_exception.txt"};
		
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
		return this.novoController.adicionaItemPorQtd(nome, categoria, qtd, unidadeDeMedida, localDeCompra, preco);
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
		return this.novoController.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
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
		return this.novoController.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
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
		this.novoController.atualizaItem(idNumerico, atributo, novoValor);
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
		this.novoController.adicionaPrecoItem(idNumerico, localDeCompra, preco);
	}

	/**
	 * Metodo que recebe um inteiro idNumerico ( que identifica cada item), e
	 * atraves desse id retorna a string que representa o item. Alem disso o metodo
	 * ordena a lista de itens cadastrados por ordem alfabetica
	 * 
	 * @return retorna a representacao o item indicado atraves do idnumerico
	 */
	public String exibeItem(int idNumerico) {
		return this.novoController.exibeItem(idNumerico);
	}
	
	/**
	 * Metodo que recebe o idNumerico do item e atraves dele o deleta do mapa de
	 * intens cadastrados
	 * 
	 * @param idNumerico
	 *            int que intenfica cada item e eh imutavel.
	 */

	public void deletaItem(String idNumerico) {
		this.novoController.deletaItem(idNumerico);
	}

	/**
	 * Metodo que recebe um inteiro idNumerico ( que identifica cada item), e
	 * atraves desse id retorna a string que representa o item. Alem disso o metodo
	 * ordena a lista de itens cadastrados por ordem alfabetica
	 * 
	 * @return retorna a representacao o item indicado atraves do idnumerico
	 */
	public Item getItem(int idNumerico) {
		return this.novoController.getItem(idNumerico);
	}
	
	public void adicionaCompraALista(String descricao, double quantidade, int idNumerico) {
		Item item = this.novoController.getItem(idNumerico);
		this.controllerCompras.adicionaCompraALista(descricao, quantidade, item);
		 
	}
}
