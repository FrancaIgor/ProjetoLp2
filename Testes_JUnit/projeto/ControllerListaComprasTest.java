package projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControllerListaComprasTest {

	ControllerListaCompras controllerListas = new ControllerListaCompras();
	Item novoItem = new ItemPorUnidade("Farinha de Trigo", "alimento industrializado", 1,
										"Mercado da esquina", 2.50);
	
	@Before
	public void setBefore() {
		this.controllerListas.adicionaListaDeCompras("Feira de Julho");
		this.controllerListas.adicionaListaDeCompras("Compras da semana");
		this.controllerListas.adicionaCompraALista("Feira de Julho", 2, novoItem);
	}
	
	/**
	 * Espera uma excecao ao tentar adicionar uma lista com um nome vazio.
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testAdicionaListaDeComprasException() {
		this.controllerListas.adicionaListaDeCompras("");
	}
	/**
	 * Espera uma excecao ao tentar adicionar uma lista com uma descricao ja cadastrada.
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testAdicionaListaDeComprasException2() {
		this.controllerListas.adicionaListaDeCompras("Feira de Julho");
	}
	/**
	 * Esperada excecao ao buscar por uma Lista nao cadastrada.
	 */
	@Test (expected=NullPointerException.class)
	public void testPesquisaListaDeComprasException2() {
		this.controllerListas.pesquisaListaDeCompras("Feira abradacabra");
	}
	/**
	 * Deve retornar a descricao da lista especificada
	 */
	@Test
	public void testPesquisaListaDeCompras() {
		assertEquals("Compras da semana", this.controllerListas.pesquisaListaDeCompras("Compras da semana"));
	}
	/**
	 * Espera excecao ao tentar adicionar compra duplicada
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testAdicionaCompraAListaException() {
		this.controllerListas.adicionaCompraALista("Feira de Julho", 2, novoItem);
	}
	@Test
	public void testPesquisaItemNaLista() {
		this.controllerListas.pesquisaItemNaLista("Compras da semana", 2);
	}
	
}
