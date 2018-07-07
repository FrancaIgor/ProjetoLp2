package projeto;

import java.util.HashMap;

public abstract class Item {

    protected String idNumerico;
    protected String nome;
    protected double preco;
    protected String categoria;
    protected HashMap <String,String> mapaLocalPrecos;

	public Item(String nome,double valor){
	    this.idNumerico += 1;
	    this.mapaLocalPrecos = new HashMap<>();
    }

	public abstract double calculaPreco();

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public String getIdNumerico() {
        return idNumerico;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setIdNumerico(String idNumerico) {
        this.idNumerico = idNumerico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public abstract String toString();
}
