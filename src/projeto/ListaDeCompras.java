package projeto;

import java.time.LocalDateTime;
import java.util.HashMap;
/**
 * 
 * @author Victor Braga, Cleciana Santana
 *
 */
public class ListaDeCompras {

	/**
	 * Mapa de Compras de uma Lista onde o Id de um Item é a chave, e o valor é um objeto Compra
	 */
	private HashMap<Integer, Compra> colecaoCompras;
	/**
	 * Guarda as informacoes data/hora em que a Lista foi criada
	 */
	private LocalDateTime data;
	/**
	 * String que descreve uma lista. Ex: 'Feira quinzenal'
	 */
	private String descricao;
	/**
	 * Após a finalizacao de uma Lista , indica em que Estabelecimento foram realizadas as compras.
	 */
	private String localDaCompra;
	/**
	 * Após a finalizacao de uma Lista , indica o valor total das compras.
	 */
	private double valorFinalCompra;
	
	
	/**
	 * Construtor, instancia um objeto ListaDECompras. Recebe uma descricao(String).
	 * 
	 * @param descricao
	 * 			String que descreve uma lista. Ex: 'Feira quinzenal'
	 */
	public ListaDeCompras(String descricao) {
		setDescricao(descricao);
		this.data = LocalDateTime.now();
	}

	/**
	 * Getter de localDaCompra
	 * @return
	 * 			Retorna uma String que informa o local onde foram feitas as compras
	 */
	public String getLocaDaCompra() {
		return localDaCompra;
	}

	/**
	 * Setter para locaDaCompra. Lanca uma excecao caso o local de compra seja vazio ou nulo.
	 * @param locaDaCompra
	 */
	public void setLocaDaCompra(String localDaCompra) {
		if (localDaCompra.trim().isEmpty() || localDaCompra == null) {
			throw new IllegalArgumentException("local nao pode ser vazio ou nulo.");
		}
		this.localDaCompra = localDaCompra;
	}

	/**
	 * 
	 * @return
	 */
	public double getValorFinalCompra() {
		return valorFinalCompra;
	}

	/**
	 * 
	 * @param valorFinalCompra
	 */
	public void setValorFinalCompra(double valorFinalCompra) {
		if (valorFinalCompra <= 0) {
			throw new IllegalArgumentException("valor final da lista invalido.");
		}
		this.valorFinalCompra = valorFinalCompra;
	}

	/**
	 * 
	 * @return
	 */
	public HashMap<Integer, Compra> getColecaoCompras() {
		return colecaoCompras;
	}

	/**
	 * Getter de informacao sobre data/hora de criacao da Lista
	 * @return
	 */
	public LocalDateTime getData() {
		return data;
	}
	
	/**
	 * 
	 * @param novaDescricao
	 */
	private void setDescricao(String novaDescricao) {
		if (novaDescricao.trim().isEmpty() || novaDescricao == null) {
			throw new IllegalArgumentException("descritor nao pode ser vazio ou nulo.");
		}
		this.descricao = novaDescricao;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * 
	 * @param quantidade
	 * @param item
	 */
	public void adicionarCompra(double quantidade, Item item) {
		Compra novaCompra = new Compra(quantidade, item);
		this.colecaoCompras.put(item.getIdItem(), novaCompra);
	}
	
	/**
	 * 
	 * @param idNumerico
	 * @return
	 */
	public String pesquisaCompra(int idNumerico) {
		Compra novaCompra = this.colecaoCompras.get(idNumerico);
		if (novaCompra == null) {
			throw new NullPointerException("compra nao encontrada na lista.");
		}
		return novaCompra.toString();
	}
	
	public String retornaCompra(int posicaoItem) {
		return colecaoCompras.get(posicaoItem).toString();
	}
	
	
}
