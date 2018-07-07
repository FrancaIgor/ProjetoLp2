package projeto;

public class itemPorQuilo extends Item{

    private double peso;

    public itemPorQuilo(String nome, double valor,double peso) {
        super(nome, valor);
        this.peso = peso;
    }

    @Override
    public double calculaPreco() {
        return preco * peso;
    }

    @Override
    public String toString() {
    return this.idNumerico + ". " + this.nome + ", " + this.categoria + ", Preco por quilo: " + this.mapaLocalPrecos;
    }
}
