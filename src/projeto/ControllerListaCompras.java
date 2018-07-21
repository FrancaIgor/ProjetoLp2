package projeto;

import java.util.HashMap;
/**
 * Classe que controla as Listas de Compras criadas, pode adicionar e remover listas e compras, atualizar compras
 * e pesquisar por listas ou compras especificas.
 * 
 * @author Victor Braga, Cleciana Santana.
 */
public class ControllerListaCompras {

	/**
	 * Mapa que guarda as Listas cadastradas no sistema.
	 */
	HashMap<String, ListaDeCompras> colecaoDeListas = new HashMap<String, ListaDeCompras>();

	/**
	 * Metodo que cria uma lista de compras recebendo sua descricao e adiciona essa
	 * lista à uma colecao de listas. Lanca uma excecao caso a descricao seja nula ou vazia.
	 */
	public String adicionaListaDeCompras(String descricao) {
		try {
			ListaDeCompras listaNova = new ListaDeCompras(descricao);
			colecaoDeListas.put(descricao, listaNova);
			return listaNova.toString();
		} catch (Exception a) {
			throw new IllegalArgumentException("Erro na criacao de lista de compras: " + a.getMessage());
		}
	}
	
	/**
	 * Método que retorna a descricao de uma lista de compras se ela estiver cadastrada.
	 * @param descricao
	 * 			descricao da lista de compras
	 */
	public String pesquisaListaDeCompras(String descricao) {
		if (this.colecaoDeListas.containsKey(descricao)) {
			return descricao;
		}
		throw new NullPointerException("Erro na pesquisa de Lista: Lista não existe.");
	}
	
	/**
	 * Método que adiciona uma compra a lista de compras, recebendo sua descricao, um
	 * objeto Item e a quantidade deste Item na lista. Lanca uma excecao se o item nao existe.
	 * 
	 * @param descricao
	 * 			Descricao da lista de compras
	 * @param quantidade
	 * 			Quantidade de Itens da compra
	 * @param item
	 * 			Item a ser comprado
	 */
	public void adicionaCompraALista(String descricao, int quantidade, Item item) {
		if (item == null) {
			throw new NullPointerException("Erro na compra de item: item nao existe no sistema.");
		}
		colecaoDeListas.get(descricao).adicionarCompra(quantidade, item);
	}
	
	/**
	 * Método que finaliza uma lista, quando o usuario realiza as compras.
	 * 
	 * @param descricao
	 * 			Descricao da lista de compras
	 * @param localDeCompra
	 * 			Estabelecimento em que foram realizadas as compras
	 * @param valorFinal
	 * 			Valor Total de todas as compras feitas em um local
	 */
	public void finalizarListaDeCompras(String descricao, String localDeCompra, double valorFinal) {
		if (descricao.trim().isEmpty() || descricao == null) {
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}
		try {
			this.colecaoDeListas.get(descricao).setLocaDaCompra(localDeCompra);
			this.colecaoDeListas.get(descricao).setValorFinalCompra(valorFinal);

		} catch (Exception c) {
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: " + c.getMessage());
		}
	}
	
	/**
	 * Método que retorna representacao String de uma compra caso esta esteja cadastrada na Lista
	 * 
	 * @param descricao
	 * 			Descricao da Lista que pode conter a compra
	 * @param idNumerico
	 * 			ID do Item desejado
	 * @return
	 * 			Retorna uma String representacao do Objeto Compra
	 */
	public String pesquisaCompraEmLista(String descricao, int idNumerico) {
		ListaDeCompras lista = this.colecaoDeListas.get(descricao);

		if (descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo");
		}
		try {
			String saida = lista.pesquisaCompra(idNumerico);
			return saida;
			
		} catch (Exception b) {
			throw new NullPointerException("Erro na pesquisa de compra: " + b.getMessage());
		}
	}

	/**
	 * Retorna a String representacao de uma compra na lista. Caso a compra nao exista, retorna uma String vazia.
	 * 
	 * @param descricao
	 * 			Descricao da lista de compras
	 * @param idItem
	 * 			Id do item associado a compra
	 */
	public String getItemLista(String descricao, int posicaoItem) {
		return this.colecaoDeListas.get(descricao).retornaCompra(posicaoItem);
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
	public void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int quantidade) {
		this.colecaoDeListas.get(descritorLista).atualizaCompra(itemId, operacao, quantidade);
	}
	
	/**
	 * Deleta, da Lista de compras, a que esta associada ao Item recebido.
	 * 
	 * @param descritorLista
	 * 			Descritor da Lista que contem a compra.
	 * @param item
	 * 			Item associado a compra que sera remoivda.
	 */
	public void deletaCompraDeLista(String descritorLista, Item item) {
		
		if (descritorLista.trim().isEmpty() || descritorLista == null) {
			throw new IllegalArgumentException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
		}
		if (item == null) {
			throw new NullPointerException("Erro na exclusao de compra: item nao existe no sistema.");
		}
		ListaDeCompras listaAux = this.colecaoDeListas.get(descritorLista);
		
		if (listaAux.retornaCompra(item.getIdItem()).equals("")) {
			throw new NullPointerException("Erro na exclusao de compra: compra nao encontrada na lista.");
		}
		listaAux.deletaCompra(item.getIdItem());
	}
	
}
