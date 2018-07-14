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
		if (qtd < 0) {
			throw new IllegalArgumentException("valor de quantidade nao pode ser menor que zero.");
		}
		if (unidadeDeMedida.trim().isEmpty() || unidadeDeMedida == null) {
			throw new IllegalArgumentException("unidade de medida nao pode ser vazia ou nula.");
		}
		this.setUnidadeDeMedida(unidadeDeMedida);
		this.setQuantidade(qtd);
	}

	@Override
	public double calculaPreco() {
		return preco;
	}

	public void setQuantidade(int qtd) {
		this.quantidade = qtd;
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
		return super.toString() + this.quantidade + " " + this.unidadeDeMedida + ", Preco: " + this.mapaLocalPrecos;
	}
}
