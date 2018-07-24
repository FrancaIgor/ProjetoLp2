package item;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
/**
 * 
 * @author Victor Braga, Cleciana Santana
 * 		   Igor Franca
 *
 */
public class ControllerItens {

	/**
	 * Mapa de itens, a chave um inteiro correspondente ao id do item no value.
	 */
	private HashMap<Integer, Item> colecaoItens = new HashMap<Integer, Item>();

	/**
	 * 
	 * Metodo que adiciona um item que se compra com uma quantidade fixa. Ex:
	 * Algodão branco 200g
	 * 
	 * @param nome
	 *            eh o nome do que descreve o produto
	 * @param categoria
	 *            que define sua finalidade Ex: No caso de algoda seria: higiene
	 *            pessoal
	 * @param qtd
	 *            um inteiro que diz a quantidade que esse produto contem
	 * @param unidadeDeMedida
	 *            unidade de medida usada por esse produto
	 * @param localDeCompra
	 *            Local onde o produto foi comprado
	 * @param preco
	 *            preco do item
	 * @return retorna o idNumerico desse produto
	 * @throws Exception 
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qtd, String unidadeDeMedida, String localDeCompra,
			double preco) {
		Item novoItemQtd;

		try {
			novoItemQtd = new ItemPorQuantidade(nome, categoria, localDeCompra, unidadeDeMedida, qtd, preco);
			verificaItemExistente(novoItemQtd);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro no cadastro de item: " + e.getMessage());
		}
		colecaoItens.put(novoItemQtd.getIdItem(), novoItemQtd);
		return novoItemQtd.getIdItem();
	}

	/**
	 * Metodo que adiciona um item que se compra por unidade. Ex: 1 queijo minas.
	 * 
	 * @param nome
	 *            eh o nome do que descreve o produto
	 * @param categoria
	 *            que define sua finalidade Ex: 1 queijo minhas: Alimntos
	 *            industrializdos
	 * @param unidade
	 *            um numero inteiro que diz a quantidade de itens daquele que foi
	 *            comprada
	 * @param localDeCompra
	 *            Local onde o produto foi comprado
	 * @param preco
	 *            preco do item
	 * @return retorna o int idNumerico que identifica o item.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		Item novoItemUnidade;

		try {
			novoItemUnidade = new ItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
			verificaItemExistente(novoItemUnidade);

		} catch (Exception e) {
			throw new IllegalArgumentException("Erro no cadastro de item: " + e.getMessage());
		}
		colecaoItens.put(novoItemUnidade.getIdItem(), novoItemUnidade);
		return novoItemUnidade.getIdItem();
	}

	/**
	 * 
	 * 
	 * Metodo que adiciona um item que se compra por peso. Ex: 200g de carne
	 * 
	 * @param nome
	 *            eh o nome do que descreve o produto
	 * @param categoria
	 *            que define sua finalidade Ex: 200g de picinha: Alimntos nao
	 *            industrializdos
	 * @param kg
	 *            um numero real que diz a quantidade que foi comprada desse produto
	 * @param localDeCompra
	 *            Local onde o produto foi comprado
	 * @param preco
	 *            preco do item
	 * @return retorna o int idNumerico que identifica o item.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		Item novoItemQuilo;

		try {
			novoItemQuilo = new ItemPorQuilo(nome, categoria, localDeCompra, kg, preco);
			verificaItemExistente(novoItemQuilo);

		} catch (Exception e) {
			throw new IllegalArgumentException("Erro no cadastro de item: " + e.getMessage());
		}
		colecaoItens.put(novoItemQuilo.getIdItem(), novoItemQuilo);
		return novoItemQuilo.getIdItem();
	}
	
	/**
	 * Método auxiliar que verifica se um item já está registrado antes de adicioná-lo ao sistema
	 * @param item
	 * 			Objeto do tipo Item
	 */
	private void verificaItemExistente(Item item) {
		for (Item item2 : colecaoItens.values()) {
			if (item.equals(item2)) {
				throw new IllegalArgumentException("item ja cadastrado no sistema.");
			}
		}
	}

	/**
	 * Metodo que permite modificar os parametros de um item, exceto seu idNumerico
	 * 
	 * @param idNumerico
	 *            inteiro que identifica cada item e nao pode ser alterado
	 * @param atributo
	 *            string que leva o mesmo nome do atributo que se quer moficar
	 * @param novoValor
	 *            String que recebe a nova String que se quer alterar.
	 */
	public void atualizaItem(int idNumerico, String atributo, String novoValor) {
		Item item = this.colecaoItens.get(idNumerico);

		if (item == null) {
			throw new NullPointerException("Erro na atualizacao de item: item nao existe.");
		}
		if (atributo.trim().isEmpty() || atributo == null) {
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo.");
		}
		if (novoValor.trim().isEmpty() || novoValor == null) {
			throw new IllegalArgumentException(
					"Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo.");
		}
		switch (atributo) {

		case "nome":
			colecaoItens.get(idNumerico).setNome(novoValor);
			break;

		case "categoria":
			try {
				colecaoItens.get(idNumerico).setCategoria(novoValor);
			} catch (Exception e) {
				throw new IllegalArgumentException("Erro na atualizacao de item: " + e.getMessage());
			}
			break;

		case "quantidade":
			if (item instanceof ItemPorQuantidade) {
				try {
					int valorInt = Integer.parseInt(novoValor);
					((ItemPorQuantidade) item).setQuantidade(valorInt);
				} catch (Exception e) {
					throw new IllegalArgumentException("Erro na atualizacao de item: " + e.getMessage());
				}
			}
			break;

		case "unidade de medida":

			if (item instanceof ItemPorQuantidade) {
				((ItemPorQuantidade) item).setUnidadeDeMedida(novoValor);
			}
			break;

		case "unidade":

			if (item instanceof ItemPorUnidade) {
				try {
					((ItemPorUnidade) item).setunidade(Integer.parseInt(novoValor));
				} catch (Exception e) {
					throw new IllegalArgumentException("Erro na atualizacao de item: " + e.getMessage());
				}
			}
			break;

		case "kg":

			if (item instanceof ItemPorQuilo) {
				try {
					((ItemPorQuilo) item).setPeso(Double.parseDouble(novoValor));
				} catch (Exception e) {
					throw new IllegalArgumentException("Erro na atualizacao de item: " + e.getMessage());
				}
			}
			break;

		default:
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao existe.");

		}
	}

	/**
	 * Metodo que apos cadastrar um item, permite que se atribua um preco a esse
	 * item e o associe a um local de compra esse metodo pode armazenar varios
	 * precos e seus respectivos locais de compra. Um mapa eh usado para armazenar
	 * estes dados.
	 * 
	 * @param idNumerico
	 *            int que identifica cada produto e eh imutavel
	 * 
	 * @param localDeCompra
	 *            local onde o produto foi comprado com aquele determinado preco
	 * 
	 * @param preco
	 *            preco do protudo no local de compra especificado
	 */
	public void adicionaPrecoItem(int idNumerico, String localDeCompra, double preco) {
		if (idNumerico < 0) {
			throw new IllegalArgumentException("Erro no cadastro de preco: id de item invalido.");
		}
		Item itemAux = colecaoItens.get(idNumerico);
		if (itemAux == null) {
			throw new NullPointerException("Erro no cadastro de preco: item nao existe.");
		}
		try {
			this.colecaoItens.get(idNumerico).adicionaPreco(localDeCompra, preco);

		} catch (Exception e) {
			throw new IllegalArgumentException("Erro no cadastro de preco: " + e.getMessage());
		}
	}

	/**
	 * Metodo que retorna a representacao String do item correspondente ao
	 * idNumerico passado
	 * 
	 * @param idNumerico
	 *            inteiro que identifica o item.
	 * @return retorna a representacao String do item correspondente ao idNumerico
	 */
	public String exibeItem(int idNumerico) {

		if (idNumerico < 0) {
			throw new IllegalArgumentException("Erro na listagem de item: id invalido.");
		}
		Item auxiliar = colecaoItens.get(idNumerico);
		if (auxiliar == null) {
			throw new NullPointerException("Erro na listagem de item: item nao existe.");
		}
		return auxiliar.toString();
	}

	/**
	 * Metodo que recebe o idNumerico do item e atraves dele o deleta do mapa de
	 * intens cadastrados
	 * 
	 * @param idNumerico
	 *            int que intenfica cada item e eh imutavel.
	 */
	public void deletaItem(String idNumerico) {
		int intIdNumerico = Integer.parseInt(idNumerico);
		colecaoItens.remove(intIdNumerico);
	}

	/**
	 * Metodo que recebe o id numerico que identifica e retorna a representacao
	 * do teim. Os itens sao ordenados por ordem alfabetica
	 * 
	 * @param idNumerico
	 * 			inteiro que identifica cada item
	 * @return 
	 * 			retornará o item que eh identificado pelo id.
	 */
	public String getItem(int idNumerico) {
		if (idNumerico < 0) {
			throw new IllegalArgumentException("Erro: posicao invalida.");
		}
		if (idNumerico >= colecaoItens.size()) {
			return "";
		}
		Collection<Item> valores = colecaoItens.values();
		ArrayList<Item> itens = new ArrayList<Item>(valores);
		Collections.sort(itens);
		
		return itens.get(idNumerico).toString();
	}

	/**
	 * Método que ordena os itens da categoria informada por ordem alfabetica. 
	 * Retorna uma String vazia e item nao existe.
	 * 
	 * @param categoria
	 * 			Categoria a qual o item pertence
	 * @param posicao
	 * 			Posicao ocupada pelo item
	 * @return
	 * 			Representacao String do item
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		if (posicao < 0) {
			throw new IllegalArgumentException("Erro na pesquisa por categoria: posicao invalida.");
		}
		try {
			CategoriasEnum.valueOf(categoria.toUpperCase().replaceAll(" ", "_"));
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na listagem de item: categoria nao existe.");
		}
		ArrayList<Item> itensCategoria = new ArrayList<>();	
		for (Item item : colecaoItens.values()) {
			
			if (item.getCategoria().equalsIgnoreCase(categoria)) {
				itensCategoria.add(item);
			}
		}
		Collections.sort(itensCategoria);
		
		if (posicao >= itensCategoria.size()) {
			return "";
		}
		return itensCategoria.get(posicao).toString();
	}
	
	public String getItemPorMenorPreco(int posicao) {
		if (posicao < 0) {
			throw new IllegalArgumentException("Erro na pesquisa por categoria: posicao invalida.");
		}
		Collection<Item> valores = colecaoItens.values();
		ArrayList<Item> itensOrdenados = new ArrayList<Item>(valores);
		
		if (posicao >= itensOrdenados.size()) {
			return "";
		}
		Collections.sort(itensOrdenados, new ComparatorPreco());

		return itensOrdenados.get(posicao).toString();
	}
	
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		if (posicao < 0) {
			throw new IllegalArgumentException("Erro na pesquisa por categoria: posicao invalida.");
		}
		ArrayList<Item> itensRelacionados = new ArrayList<>();
		
		for (Item item : this.colecaoItens.values()) {
			
			if (item.getNome().toLowerCase().contains(strPesquisada.toLowerCase())) {
				itensRelacionados.add(item);
			}
		}
		if (posicao >= itensRelacionados.size()) {
			return "";
		}
		Collections.sort(itensRelacionados);
		
		return itensRelacionados.get(posicao).toString();
	}
	
	public HashMap<Integer, Item> getColecaoItens() {
		return this.colecaoItens;
	}

	public Item getItemInstance(int idItem) {
		return colecaoItens.get(idItem);
	}
	
}
