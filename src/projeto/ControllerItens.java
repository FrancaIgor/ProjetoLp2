package projeto;
import java.util.HashMap;

public class ControllerItens {

	HashMap<Integer, Item> colecaoItens = new HashMap<Integer, Item>();

	public String adicionaItemPorQtd(String nome, String categoria, int qtd, String unidadeDeMedida, String localDeCompra, double preco) {
		String statusCadastroQtd = "";
		Item novoItemQtd = new ItemPorQuantidade(nome, categoria, localDeCompra, unidadeDeMedida, qtd, preco);
		colecaoItens.put(novoItemQtd.getIdItem(), novoItemQtd);
		statusCadastroQtd = "CADASTRO REALIZADO";

		return statusCadastroQtd;
	}

	public String adionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		String statusCadastroUnidade = "";
		Item novoItemUnidade = new ItemPorUnidade(nome, categoria, localDeCompra, unidade, preco);
		colecaoItens.put(novoItemUnidade.getIdItem(), novoItemUnidade);
		statusCadastroUnidade = "CADASTRO REALIZADO";

		return statusCadastroUnidade;
	}

	public String adionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		String statusCadastroQuilo = "";
		Item novoItemQuilo = new ItemPorQuilo(nome, categoria, localDeCompra, kg, preco);
		colecaoItens.put(novoItemQuilo.getIdItem(), novoItemQuilo);
		statusCadastroQuilo = "CADASTRO REALIZADO";

		return statusCadastroQuilo;

	}

	public void atualizaItem(int idNumerico, String atributo, String novoValor) {
		Item item = this.colecaoItens.get(idNumerico);
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

	public void adicionaPrecoItem(int idNumerico, String mercado, double preco) {
		colecaoItens.get(idNumerico).adicionaPreco(mercado, preco);

	}

	public void deletaItem(String idNumerico) {
		int intIdNumerico = Integer.parseInt(idNumerico);
		colecaoItens.remove(intIdNumerico);

	}

}
