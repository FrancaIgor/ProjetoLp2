package projeto;

/**
 * Representação da Classe item para itens comprados em quantidades de medida.
 * 
 * @author Igor Franca, Cleciana Santana
 *
 */
public class ItemPorQuantidade extends Item {

	private int quantidade;
	private String unidadeDeMedida;

	public ItemPorQuantidade(String nome, String categoria, String localDeCompra, String unidadeDeMedida, int qtd, double preco) {
		super(nome, categoria, localDeCompra, preco);
		this.quantidade = qtd;
	}

	@Override
	public double calculaPreco() {
		return preco;
	}

	public void setQuantidade(int valorInt) {
		this.quantidade = valorInt;
	}

	public void setUnidadeDeMedida(String novoValor) {
		this.unidadeDeMedida = novoValor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	@Override
	public String toString() {
		return super.toString() + this.quantidade + " " + this.unidadeDeMedida
				+ ", Preco: " + this.mapaLocalPrecos;
	}
}
