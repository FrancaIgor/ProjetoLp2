package projeto;

public class ItemPorUnidade extends Item {
	
    public ItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
    	
        super(nome, categoria, localDeCompra, preco);
        
        if (unidade < 0) {
        	throw new IllegalArgumentException("valor de unidade nao pode ser menor que zero.");
        }
    }

    @Override
    public double calculaPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return super.toString() + ", Preco: " + this.mapaLocalPrecos;
    }
}
