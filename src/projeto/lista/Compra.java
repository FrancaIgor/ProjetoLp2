package projeto.lista;

import java.io.Serializable;

import projeto.item.Item;

/**
 * Classe que representa uma Compra, guarda o Item associado a ela uma quantidade desses Itens.
 * 
 * @author Cleciana Santana
 */
public class Compra implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Inteiro que indica a quantidade de itens a ser comprada.
	 */
	private int quantidade;
	/**
	 * Objeto Item associado a compra.
	 */
	private Item item;
	
	/**
	 * Instancia um objeto Compra recebendo sua quantidade e um objeto Item associado.
	 * 
	 * @param quantidade
	 * 			Quantidade de Item.
	 * @param item
	 * 			Objeto Item associado.
	 */
	public Compra(int quantidade, Item item) {
		setQuantidade(quantidade);
		this.item = item;
	}

	/**
	 * @return
	 * 			Retorna a quantidade de itens de uma Compra.
	 */
	public int getQuantidade() {
		return this.quantidade;
	}

	/**
	 * Altera a quantidade de Itens da compra.
	 * 
	 * @param quantidade
	 */
	public void setQuantidade(int novaQuantidade) {
		if (quantidade < 0) {
			throw new IllegalArgumentException("Erro: Quantidade nao pode ser menor que zero.");
		}
		this.quantidade = novaQuantidade;
	}
	
	/**
	 * Pega o item associado a compra.
	 * 
	 * @return
	 * 			Objeto item
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Representacao String de um objeto Compra.
	 */
	public String toString() {
		return this.quantidade + " " + item.getInfo();
	}

}
