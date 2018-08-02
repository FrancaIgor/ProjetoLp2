package projeto;

import static org.junit.Assert.*;
import org.junit.Test;
import projeto.item.ControllerItens;
import projeto.item.Item;
/**
 * Classe de testes para o controller de itens
 * 
 * @author Igor Franca
 */
public class ControllerItensTest {
	
	private ControllerItens itens = new ControllerItens();
	private Item item;
	
	@Test
	public void testAdicionaItemPorQtd() {
		this.itens.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
		this.item = this.itens.getItemInstance(1);
		assertEquals(item, item);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdNomeNull() {
		this.itens.adicionaItemPorQtd("", "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdCategoriaNull() {
		this.itens.adicionaItemPorQtd("Agua Sanitaria Drogon", "", 1, "l", "Supermercado Excepcional", 2.19);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdQuantidadeNegativa() {
		this.itens.adicionaItemPorQtd("Agua Sanitaria Drogon", "", -1, "l", "Supermercado Excepcional", 2.19);
	}
	
	@Test
	public void testAdicionaItemPorUnidade() {
		this.itens.adicionaItemPorUnidade("Esponja de Aco Assolange", "limpeza", 1, "ml", 3.50);
	}

	@Test
	public void testAdicionaItemPorQuilo() {
		this.itens.adicionaItemPorQuilo("Limao alienigina", "alimento nao industrializado", 1.0,"Supermercado Excepcional", 4.19);
	}

	@Test(expected = NullPointerException.class)
	public void testAtualizaItemNulo() {
		this.itens.atualizaItem(0, "quantidade", "2");
	}

	@Test(expected = NullPointerException.class)
	public void testAdicionaPrecoItemNulo() {
		this.itens.adicionaPrecoItem(1, "Mercado", 0.5);
	}

	@Test (expected = NullPointerException.class) 
	public void testExibeItemItemNulo() {
		assertEquals("14. Presunto, alimento industrializado, 60 grama, Preco: <Supermercado SemNome, R$ 1,20;>",this.itens.exibeItem(9));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExibeItemIdNegativo() {
		this.itens.exibeItem(-1);
	}

	@Test(expected = NullPointerException.class)
	public void testExibeItemNulo() {
		this.itens.exibeItem(1);
	}

	@Test
	public void testDeletaItem() {
		this.itens.adicionaItemPorQtd("Oregano", "alimento industrializado", 60, "grama", "Supermercado SemNome",1.20);
		int tamanhoDoMapa = this.itens.getColecaoItens().size();

		this.itens.deletaItem("8");
		int tamanhoDoMapa2 = this.itens.getColecaoItens().size();
		
		assertEquals(tamanhoDoMapa-1, tamanhoDoMapa2);
	}

	@Test
	public void testGetItem() {
		this.itens.adicionaItemPorQtd("Queijo ralado", "alimento industrializado", 60, "grama", "Supermercado SemNome",1.20);
		assertEquals("6. Queijo ralado, alimento industrializado, 60 grama, Preco: <Supermercado SemNome, R$ 1,20;>",this.itens.getItem(0));
	}

	@Test
	public void testGetItemPorCategoria() {
		this.itens.adicionaItemPorQtd("Arroz", "alimento industrializado", 60, "grama", "Supermercado SemNome",1.20);
		assertEquals("4. Arroz, alimento industrializado, 60 grama, Preco: <Supermercado SemNome, R$ 1,20;>",this.itens.getItemPorCategoria("alimento industrializado", 0));
	}

	@Test
	public void testGetItemPorMenorPreco() {
		this.itens.adicionaItemPorQtd("Macarrao", "alimento industrializado", 60, "grama", "Supermercado SemNome",1.20);
		assertEquals("10. Macarrao, alimento industrializado, 60 grama, Preco: <Supermercado SemNome, R$ 1,20;>",this.itens.getItemPorMenorPreco(0));
	}

	@Test
	public void testGetItemPorPesquisa() {
		this.itens.adicionaItemPorQtd("Fini", "alimento industrializado", 60, "grama", "Supermercado SemNome",1.20);
		assertEquals("3. Fini, alimento industrializado, 60 grama, Preco: <Supermercado SemNome, R$ 1,20;>",this.itens.getItemPorPesquisa("Fini", 0));
	}

	@Test
	public void testGetItemInstance() {
		this.itens.adicionaItemPorQtd("Tomate", "alimento industrializado", 60, "grama", "Supermercado SemNome",1.20);
		Item item = this.itens.getItemInstance(2);
		assertNotEquals(null, item);
	}
	
	@Test (expected=NullPointerException.class)
	public void testGetItemInstancePosicaoNegativa() {
		this.itens.adicionaItemPorQtd("Peito de Peru", "alimento industrializado", 60, "grama", "Supermercado SemNome",1.20);
		this.item = this.itens.getItemInstance(-50);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetItemInstanceNomeNull() {
		this.itens.adicionaItemPorQtd(null, "alimento industrializado", 60, "grama", "Supermercado SemNome", 1.20);
		this.item = this.itens.getItemInstance(0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetItemInstanceCategoriaNull() {
		this.itens.adicionaItemPorQtd("Queijo ralado", null, 60, "grama", "Supermercado SemNome", 1.20);
		this.item = this.itens.getItemInstance(0);
	}
	
}
