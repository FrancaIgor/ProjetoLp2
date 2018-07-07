package projeto;

public class itemPorQuantidade extends Item{

    private int quantidade;

    public itemPorQuantidade(String nome, double preco, int quantidade) {
        super(nome, preco);
        this.quantidade = quantidade;
    }

    @Override
    public double calculaPreco() {
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return this.idNumerico + ". " + this.nome + ", " + this.categoria + ", Preco: " + this.mapaLocalPrecos;
    }
}
