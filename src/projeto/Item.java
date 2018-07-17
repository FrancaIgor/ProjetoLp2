package projeto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

import javax.swing.RowFilter.Entry;

public abstract class Item {

    private static int idNumerico = 1;
    protected int idItem;
    protected String nome;
    protected double preco;
    protected CategoriasEnum categoria;
    protected HashMap <String,Double> mapaLocalPrecos;

	public Item(String nome, String categoria, String localDeCompra, double preco){
		String.valueOf(preco);

		this.setNome(nome);
		this.setCategoria(categoria);
		this.setPreco(preco);
	    this.idItem = getIdNumerico();
	    this.mapaLocalPrecos = new HashMap<>();
	    adicionaPreco(localDeCompra, preco);
    }

	public abstract double calculaPreco();

	//método na classe item pra poder adicionar os precos e locais de comra no mapa
	public void adicionaPreco(String localDeCompra, double preco) {

		if (localDeCompra.trim().isEmpty() || localDeCompra == null) {
			throw new IllegalArgumentException("local de compra nao pode ser vazio ou nulo.");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("preco de item invalido.");
		}
		mapaLocalPrecos.put(localDeCompra, preco);
	}
	
	public class nameComparator implements Comparator<Item> {
        public int compare(final Item item1, final Item item2) {
        	return item1.getNome().compareToIgnoreCase(item2.getNome());
        }
	}
	
    public double getPreco() {
        return this.preco;
    }

    public String getNome() {
        return this.nome;
    }
    
    public static int getIdNumerico() {
    	return idNumerico++;
    }
    
    public String getCategoria() {
        return this.categoria.toString();
    }
    
    public void setCategoria(String categoria) {
		if (categoria.trim().isEmpty() || categoria == null) {
			throw new IllegalArgumentException("categoria nao pode ser vazia ou nula.");
		}
		
		try {
			this.categoria = CategoriasEnum.valueOf(categoria.toUpperCase().replaceAll(" ", "_"));
		} catch (Exception e) {
			throw new IllegalArgumentException("categoria nao existe.");
		}
    }

    public void setPreco(double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("preco de item invalido.");
		}
        this.preco = preco;
    }

    public void setNome(String nome) {
		if (nome.trim().isEmpty()|| nome == null) {
			throw new IllegalArgumentException("nome nao pode ser vazio ou nulo.");
		}
        this.nome = nome;
    }
    
    @Override
    public String toString() {
    	return this.idItem + ". " + this.nome + ", " + this.categoria;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + idItem;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	public String getExibirPrecos() {
		String saida = "<";
		Set<java.util.Map.Entry<String, Double>> auxiliar = mapaLocalPrecos.entrySet();
		for (java.util.Map.Entry<String, Double> entry : auxiliar) {
			saida += entry.getKey() + ", R$ " + String.format("%.2f",entry.getValue()).replace(".",",") + ";";
			
		}
		return saida + ">";
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
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (idItem != other.idItem)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public int getIdItem() {
		return idItem;
	}

}