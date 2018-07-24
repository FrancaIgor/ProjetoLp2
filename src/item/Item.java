package item;

import java.util.HashMap;
import java.util.Set;
/**
 * 
 * @author Cleciana Santana
 * 
 */
public abstract class Item implements Comparable<Item> {

    private static int idNumerico = 1;
    private int idItem;
    protected String nome;
    protected double preco;
    protected CategoriasEnum categoria;
    protected HashMap <String,Double> mapaLocalPrecos;

	public Item(String nome, String categoria, String localDeCompra, double preco){

		this.setNome(nome);
		this.setCategoria(categoria);
		this.setPreco(preco);
	    this.idItem = getIdNumerico();
	    this.mapaLocalPrecos = new HashMap<>();
	    adicionaPreco(localDeCompra, preco);
    }

	/**
	 * Retorna o preco do Item, padrão para ItemPorQuantidade e para ItemPorUnidade.
	 * 
	 * @return
	 * 			Valor de venda do item
	 */
	public double calculaPreco() {
		return this.preco;
	}

	/**
	 * Metodo usado para adicionar um local de compra e um preco ao Item
	 * 
	 * @param localDeCompra
	 * 			Estabelecimento em que foi realizada a compra
	 * @param preco
	 * 			Custo do item no estabelecimento
	 */
	public void adicionaPreco(String localDeCompra, double preco) {

		if (localDeCompra.trim().isEmpty() || localDeCompra == null) {
			throw new IllegalArgumentException("local de compra nao pode ser vazio ou nulo.");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("preco de item invalido.");
		}
		mapaLocalPrecos.put(localDeCompra, preco);
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

    /**
     * Altera o nome do item para o nome recebido
     * 
     * @param nome
     * 			String que indica o novo nome de item
     */
    public void setNome(String nome) {
		if (nome.trim().isEmpty()|| nome == null) {
			throw new IllegalArgumentException("nome nao pode ser vazio ou nulo.");
		}
        this.nome = nome;
    }
    
    /**
     * Retorna uma representacao do objeto no formato
     * ID. NOME, CATEGORIA
     */
    @Override
    public String toString() {
    	return this.idItem + ". " + this.nome + ", " + this.categoria;
    }

    /**
     * Gera um inteiro único de cada objeto Item que o identifica.
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/**
	 * Retorna uma string representacao contendo todos os locais de compra e preco associados
	 * 
	 * @return
	 * 			String contendo todos os locais de compra e precos
	 */
	public String exibirPrecos() {
		String saida = "<";
		Set<java.util.Map.Entry<String, Double>> auxiliar = mapaLocalPrecos.entrySet();
		
		for (java.util.Map.Entry<String, Double> entry : auxiliar) {
			saida += entry.getKey() + ", R$ " + String.format("%.2f", entry.getValue()).replace(".",",") + ";";
		}
		return saida + ">";
	}

	/**
	 * Verifica se dois itens são iguais, baseado em seus nomes e categorias
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (categoria != other.categoria)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public int getIdItem() {
		return this.idItem;
	}

	@Override
	public int compareTo(Item item) {
		return this.toString().compareTo(item.toString());
	}
	
}
