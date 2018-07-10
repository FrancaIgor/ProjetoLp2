package projeto;
/**
 * Representação da Classe item para itens comprados em quantidades de medida.
 * @author Igor Franca
 *
 */
public class itemPorQuantidade extends Item {
	
    private int quantidade;
    private String unidadeDeMedida;

    public itemPorQuantidade(String nome, double preco, int quantidade) {
        super(nome, preco);
        this.quantidade = quantidade;
    }

    @Override
    public double calculaPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return this.idNumerico + ". " + this.nome + ", " + this.categoria + this.quantidade +  " "  + this.unidadeDeMedida + ", Preco: " + this.mapaLocalPrecos;
    }
}
