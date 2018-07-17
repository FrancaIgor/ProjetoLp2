package projeto;

public class ItemPorUnidade extends Item {
	
	private int unidade;
	
    public ItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
    	
        super(nome, categoria, localDeCompra, preco);      
        this.setunidade(unidade);
    }

    public void setunidade(int unidade) {
		if (unidade < 0) {
	        	throw new IllegalArgumentException("valor de unidade nao pode ser menor que zero.");
	        }
		this.unidade = unidade;
	}
    
    public int getUnidade() {
    	return unidade;
    }
    

	@Override
    public double calculaPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return super.toString() + ", Preco: " + getExibirPrecos();
    }
}
