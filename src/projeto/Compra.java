package projeto;

public class Compra {

	private double quantidade;
	private Item item;
	
	public Compra(double quantidade2, Item item) {
		setQuantidade(quantidade2);
		this.item = item;
	}

	public void setQuantidade(double quantidade2) {
		if (quantidade < 0) {
			throw new IllegalArgumentException("Erro: Quantidade nao pode ser menor que zero.");
		}
		this.quantidade = quantidade2;
	}
	
	public String toString() {
		return this.quantidade + item.toString().substring("".indexOf(". "), "".indexOf(", P"));
	}
}
