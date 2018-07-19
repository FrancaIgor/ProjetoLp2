package projeto;

import java.util.HashMap;

/**
 * 
 * @author Victor Braga, Cleciana Santana.
 *
 */
public class ControllerListaCompras {

	HashMap<String, ListaDeCompras> colecaoDeListas = new HashMap<String, ListaDeCompras>();

	/**
	 * Metodo que cria uma lista de compras recebendo sua descricao e adiciona essa
	 * lista à uma colecao de listas. Lanca uma excecao caso a descricao seja nula ou vazia.
	 * 
	 */
	public void adicionaListaDeCompras(String descricao) {
		try {
			ListaDeCompras listaNova = new ListaDeCompras(descricao);
			colecaoDeListas.put(descricao, listaNova);
			
		} catch (Exception a) {
			throw new IllegalArgumentException("Erro na criacao de lista de compras: " + a.getMessage());
		}
	}
	
	/**
	 * Método que retorna a descricao de uma lista de compras se ela estiver cadastrada.
	 * @param descricao
	 * 			descricao da lista de compras
	 * @return
	 */
	public String pesquisaListaDeCompras(String descricao) {
		String descricaoLista = null;
		if (colecaoDeListas.containsKey(descricao)) {
			descricaoLista = descricao;
		}
		return descricaoLista;
	}
	
	/**
	 * Método que adiciona uma compra a lista de compras, recebendo sua descricao, um
	 * objeto Item e a quantidade deste Item na lista
	 * 
	 * @param descricao
	 * @param quantidade
	 * @param item
	 */
	public void adicionaCompraALista(String descricao, double quantidade, Item item) {
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
		try {
			this.colecaoDeListas.get(descricao).setLocaDaCompra(localDeCompra);
			this.colecaoDeListas.get(descricao).setValorFinalCompra(valorFinal);

		} catch (Exception c) {
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: " + c.getMessage());
		}
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
	public String pesquisaItemNaLista(String descricao, int idNumerico) {
		ListaDeCompras lista = this.colecaoDeListas.get(descricao);
		try {
			return lista.pesquisaCompra(idNumerico);
			
		} catch (Exception b) {
			throw new NullPointerException("Erro na pesquisa de compra: " + b.getMessage());
		}
	}
}
