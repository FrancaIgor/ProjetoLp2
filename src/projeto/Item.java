package projeto;

import java.util.HashMap;

public abstract class Item {

    protected int idNumerico;
    protected String nome;
    protected double preco;
    protected String categoria;
    protected HashMap <String,Double> mapaLocalPrecos;

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

    public int getIdNumerico() {
        return idNumerico;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
    	this.categoria = categoria;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public abstract String toString();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idNumerico;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (idNumerico != other.idNumerico)
			return false;
		return true;
	}

    
}
