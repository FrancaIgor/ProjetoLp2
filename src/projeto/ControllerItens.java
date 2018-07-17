package projeto;
import java.util.*;

/**
 * 
 * @author Victor Braga, 
 * 		   Cleciana Santana
 *
 */
public class ControllerItens {
	/**
	 * Metodo de comparacao para ordenamento.
	 */
	private String comparador;
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
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qtd, String unidadeDeMedida, String localDeCompra, double preco) {
		Item novoItemQtd;

		try {
			novoItemQtd = new ItemPorQuantidade(nome, categoria, localDeCompra, unidadeDeMedida, qtd, preco);
			
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
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro no cadastro de item: " + e.getMessage());
		}
		colecaoItens.put(novoItemQuilo.getIdItem(), novoItemQuilo);
		return novoItemQuilo.getIdItem();
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
			throw new IllegalArgumentException("Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo.");
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
		
		String saida = "";
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
	 * Possibilita a escolha do tipo do ordenamento que sera aplicado na lista de cenarios cadastrados.
	 *
	 * @param ordem tipo de ordenamento.
	 */
	public void alteraOrdem(String ordem) {
		String erro = "Erro ao alterar ordem: ";

		if (ordem == null) throw new NullPointerException(erro + "Ordem nao pode ser vazia ou nula");
		if (ordem.equals(""))
			throw new IllegalArgumentException(erro + "Ordem nao pode ser vazia ou nula");

		if (ordem.equals("cadastro") || ordem.equals("nome") || ordem.equals("apostas")) this.comparador = ordem;

		else throw new IllegalArgumentException(erro + "Ordem invalida");

	}
	public String getItemPorCategoria() {
		List<Item> itensOrdenados = new ArrayList<>(colecaoItens.;);
		itensOrdenados.addAll((Collection<? extends Item>) colecaoItens);
		Collections.sort(itensOrdenados, new ComparatorNome());
		Collections.sort(itensOrdenados, new ComparatorPreco());;
		return itensOrdenados.toString();
	}
}
