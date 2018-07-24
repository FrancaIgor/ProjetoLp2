package item;
/**
 * Classe que representa um objeto Item, do tipo que se compra por Quilo
 * .
 * @author Igor Franca
 */
public class ItemPorQuilo extends Item {

	/**
	 * Indica o peso, em kg, em que o item é vendido.
	 */
    private double peso;
    
	/**
	 * Cria um Item por Quilo.
	 * 
	 * @param nome
	 * 			Nome do Item
	 * @param categoria
	 * 			Categoria de Item
	 * @param localDeCompra
	 * 			Local onde o Item pode ser comprado
	 * @param peso
	 * 			Peso, em kg, do item.
	 * @param preco
	 * 			Preco do item
	 */
    public ItemPorQuilo(String nome, String categoria, String localDeCompra, double peso, double preco) {
    	
        super(nome, categoria, localDeCompra, preco);       
        setPeso(peso);
    }
    
    /**
     * Retorna o peso do item.
     * 
     * @return
     * 			Double que indica o quantos kg de um Item eh vendido.
     */
    public double getPeso() {
		return peso;
	}

    /**
     * Altera o peso(kg) de um Item por Quilo
     * @param peso
     */
	public void setPeso(double peso) {
		if (peso < 0) {
        	throw new IllegalArgumentException("valor de quilos nao pode ser menor que zero.");
        }
		this.peso = peso;
	}

	 /**
     * Calcula e retorna o preco do Item
     */
	@Override
    public double calculaPreco() {
        return preco * peso;
    }
	
	/**
	 * Representacao String de um Item por Quilo
	 */
    @Override
    public String toString() {
    	return super.toString() + ", Preco por quilo: " + exibirPrecos();
    }
}
