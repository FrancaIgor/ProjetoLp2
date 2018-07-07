package projeto;

public class itemPorUnidade extends Item{

    public itemPorUnidade(String idNumerico, String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public double calculaPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return this.idNumerico + ". " + this.nome + ", " + this.categoria + ", Preco: " + this.mapaLocalPrecos;
    }
}
