package projeto;
/**
 * Representação da Classe item para itens comprados por quantidade. Ex: 100 gramas
 * 
 * @author Igor Franca, Cleciana Santana
 */
public class ItemPorQuantidade extends Item {

	/**
	 * Quantidadadee de venda do item
	 */
	private int quantidade;
	/**
	 * Representa qual a unidade de medida usada no item Ex: gramas.
	 */
	private String unidadeDeMedida;

	/**
	 * Cria um Item por Unidade.
	 * 
	 * @param nome
	 * 			Nome do Item
	 * @param categoria
	 * 			Categoria de Item
	 * @param unidade
	 * 			Quantidadadee de venda do item
	 * @param unidadeDeMedida
	 * 			String que representa qual a unidade de medida usada no item Ex: gramas.
	 * @param preco
	 * 			Preco do item
	 */
	public ItemPorQuantidade(String nome, String categoria, String localDeCompra, String unidadeDeMedida, int qtd, double preco) {
		
		super(nome, categoria, localDeCompra, preco);
		
		if (unidadeDeMedida.trim().isEmpty() || unidadeDeMedida == null) {
			throw new IllegalArgumentException("unidade de medida nao pode ser vazia ou nula.");
		}
		this.setUnidadeDeMedida(unidadeDeMedida);
		this.setQuantidade(qtd);
	}

	 /**
     * Calcula e retorna o preco do Item
     */
	@Override
	public double calculaPreco() {
		return preco;
	}

	public void setQuantidade(int qtd) {
		if (qtd < 0) {
			throw new IllegalArgumentException("valor de quantidade nao pode ser menor que zero.");
		}
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

	/**
	 * Representacao String de um Item por Quantidade
	 */
	@Override
	public String toString() {
		return super.toString() + ", " + this.quantidade + " " + this.unidadeDeMedida + ", Preco: " + getExibirPrecos();
	}
}
