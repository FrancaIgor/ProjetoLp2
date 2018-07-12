package projeto;

public class ItemPorQuilo extends Item{

    private double peso;

    public ItemPorQuilo(String nome, String categoria, String localDeCompra, double peso, double preco) {
        super(nome, categoria, localDeCompra, preco);
        this.peso = peso;
    }

    @Override
    public double calculaPreco() {
        return preco * peso;
    }

    @Override
    public String toString() {
    	return super.toString() + ", Preco por quilo: " + this.mapaLocalPrecos;
    }
}
