package projeto;

import easyaccept.EasyAccept;
/**
 * 
 * @author Victor Braga
 *
 */
public class Facade {

	ControllerItens novoController = new ControllerItens();

	public static void main (String[] args) {
		args = new String[] {"projeto.Facade", "testes/use_case1_exception.txt"};
		
		EasyAccept.main(args);
	}
	
	public String adicionaItemPorQtd(String nome, String categoria, int qtd, String unidadeDeMedida, String localDeCompra, double preco) {
		return this.novoController.adicionaItemPorQtd(nome, categoria, qtd, unidadeDeMedida, localDeCompra, preco);
	}

	public String adionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return this.novoController.adionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	public String adionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return this.novoController.adionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}

	public void atualizaItem(int idNumerico, String atributo, String novoValor) {
		this.novoController.atualizaItem(idNumerico, atributo, novoValor);

	}

	public void adicionaPrecoItem(int idNumerico, String localDeCompra, double preco) {
		this.novoController.adicionaPrecoItem(idNumerico, localDeCompra, preco);
	}

	public String exibeItem(int idNumerico) {
		return this.novoController.exibeItem(idNumerico);
	}
	
	public void deletaItem(String idNumerico) {
		this.novoController.deletaItem(idNumerico);
	}

}
