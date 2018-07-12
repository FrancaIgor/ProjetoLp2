package projeto;

public class ItemPorUnidade extends Item{

    public ItemPorUnidade(String nome, String categoria, String localDeCompra, double valor, double preco) {
        super(nome, categoria, localDeCompra, valor);
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
