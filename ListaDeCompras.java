package projeto;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ListaDeCompras {

	private HashMap<Integer, Compra> colecaoCompras;

	private LocalDateTime data;
	private String descricao;
	private String locaDaCompra;
	private double valorFinalCompra;
	
	public ListaDeCompras(String descricao) {
		this.descricao = descricao;
		this.data = LocalDateTime.now(); 	
	}

	public String getLocaDaCompra() {
		return locaDaCompra;
	}

	public void setLocaDaCompra(String locaDaCompra) {
		this.locaDaCompra = locaDaCompra;
	}

	public double getValorFinalCompra() {
		return valorFinalCompra;
	}

	public void setValorFinalCompra(double valorFinalCompra) {
		this.valorFinalCompra = valorFinalCompra;
	}

	public HashMap<Integer, Compra> getColecaoCompras() {
		return colecaoCompras;
	}

	public LocalDateTime getData() {
		return data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void adicionarCompra(double quantidade, Item item) {
		Compra novaCompra = new Compra(quantidade, item);
		this.colecaoCompras.put(item.getIdItem(), novaCompra);
		
	}
	
	
}
