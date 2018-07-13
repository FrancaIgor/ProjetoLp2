package projeto;
import java.util.HashMap;
/**
 * 
 * @author Victor Braga, 
 * 		   Cleciana Santana
 *
 */
public class ControllerItens {

	private HashMap<Integer, Item> colecaoItens = new HashMap<Integer, Item>();

	public String adicionaItemPorQtd(String nome, String categoria, int qtd, String unidadeDeMedida, String localDeCompra, double preco) {
		
		String statusCadastroQtd = "";
		try {
			Item novoItemQtd = new ItemPorQuantidade(nome, categoria, localDeCompra, unidadeDeMedida, qtd, preco);
			colecaoItens.put(novoItemQtd.getIdItem(), novoItemQtd);
			statusCadastroQtd = "CADASTRO REALIZADO";
			
		} catch (Exception e) {
			return "Erro no cadastro de item: " + e.getMessage();
		}
		return statusCadastroQtd;
	}

	public String adionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		
		String statusCadastroUnidade = "";
		try {
			Item novoItemUnidade = new ItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
			colecaoItens.put(novoItemUnidade.getIdItem(), novoItemUnidade);
			statusCadastroUnidade = "CADASTRO REALIZADO";
			
		} catch (Exception e) {
			return "Erro no cadastro de item: " + e.getMessage();
		}
		return statusCadastroUnidade;
	}

	public String adionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		
		String statusCadastroQuilo = "";
		try {
			Item novoItemQuilo = new ItemPorQuilo(nome, categoria, localDeCompra, kg, preco);
			colecaoItens.put(novoItemQuilo.getIdItem(), novoItemQuilo);
			statusCadastroQuilo = "CADASTRO REALIZADO";
			
		} catch (Exception e) {
			return "Erro no cadastro de item: " + e.getMessage();
		}
		return statusCadastroQuilo;
	}

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
			colecaoItens.get(idNumerico).setCategoria(novoValor);
			break;

		case "quantidade":
			if (item instanceof ItemPorQuantidade) {
				int valorInt = Integer.parseInt(novoValor);
				((ItemPorQuantidade) item).setQuantidade(valorInt);
			}
			break;

		case "unidade de medida":

			if (item instanceof ItemPorQuantidade) {
				((ItemPorQuantidade) item).setUnidadeDeMedida(novoValor);
			}
			break;

		}
	}
	
	public void verificaItem(int idNumerico) {
		
		if (idNumerico < 0) {
			throw new IllegalArgumentException("id de item invalido");
		}
		Item itemAux = colecaoItens.get(idNumerico);
		
		if (itemAux == null) {
			throw new NullPointerException("item nao existe.");
		}
	}
	
	public void adicionaPrecoItem(int idNumerico, String localDeCompra, double preco) {

		try {
			this.verificaItem(idNumerico);
			this.colecaoItens.get(idNumerico).adicionaPreco(localDeCompra, preco);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro no cadastro de preco: " + e.getMessage());
		}
	}

	public String exibeItem(int idNumerico) {
		
		if (idNumerico < 0) {
			throw new IllegalArgumentException("Erro na listagem de item: id invalido.");
		}
		Item auxiliar = colecaoItens.get(idNumerico);
		
		if (auxiliar == null) {
			throw new NullPointerException("Erro na listagem de item: item nao existe");
		}
		return auxiliar.toString();
	}
	
	public void deletaItem(String idNumerico) {
		int intIdNumerico = Integer.parseInt(idNumerico);
		colecaoItens.remove(intIdNumerico);
	}

}
