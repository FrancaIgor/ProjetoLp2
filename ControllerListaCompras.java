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
	 * lista à uma colecao de listas.
	 * 
	 */
	public void adicionaListaDeCompras(String descricao) {
		ListaDeCompras listaNova = new ListaDeCompras(descricao);
		colecaoDeListas.put(descricao, listaNova);
	}
/**
 * 
 * @param descricao
 * @return
 */
	public String pesquisaListaDeCompras(String descricao) {
		String descricaoLista = null;
		if (colecaoDeListas.containsKey(descricao)) {
			descricaoLista = descricao;
		}

		return descricaoLista;
	}
	public void adicionaCompraALista(String descricao, double quantidade, Item item) {
		colecaoDeListas.get(descricao).adicionarCompra(quantidade, item);

	}
}
