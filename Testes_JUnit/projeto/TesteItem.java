package projeto;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import projeto.item.Item;
import projeto.item.ItemPorQuantidade;
import projeto.item.ItemPorQuilo;
import projeto.item.ItemPorUnidade;
/**
 * Testes de unidade para classe Item e filhas.
 * 
 * @author Rostanth
 */
public class TesteItem {

	private Item itemQuilo;
	private Item novoItemQuilo;
	private Item itemPorQtd;
	
	@Before
	public void CriaItemPorQuilo() {
		this.itemQuilo = new ItemPorQuilo("batata","alimento nao industrializado", "Baratao", 1.50, 1.2);
		this.itemPorQtd = new ItemPorQuantidade("alface", "alimento nao industrializado", "eskina", "g", 100, 1.00);
		this.novoItemQuilo = new ItemPorQuilo("batata", "alimento industrializado", "Baratao", 1.50, 1.2);
	}
	

	@Test
	public void testToString() {
		assertEquals("0. batata, alimento nao industrializado, Preco por quilo: <Baratao, R$ 1,20;>", this.itemQuilo.toString());
	}
	@Test
	public void testExistenciaItemPorQuilo() {
		assertNotNull(this.itemQuilo);
		
	}

	@Test
	public void testidNumerico() {
		assertEquals(0, this.itemQuilo.getIdItem());
	}
	
	@Test
	public void testEqualsItem() {
		assertNotEquals(this.itemQuilo.toString(), novoItemQuilo.toString());
	}
	
	@Test
	public void testCriaItemPorQtd() {
		itemPorQtd = new ItemPorQuantidade("Pasta de dente", "higiene pessoal","Baratão", "ml",300,2.00);
	}
	
	@Test
	public void testExistenciaItemPorQtd() {
		assertNotNull(itemPorQtd);
	}
	
	/**
	 * Espera que o id seja 0 porque o item nao foi adicionado ao sistema, apenas instanciado. Seu id inicial é 0.
	 */
	@Test
	public void testCriaItemPorUnidade() {
		ItemPorUnidade ItemPorUnidade = new ItemPorUnidade("Queijo minas Dali", "alimento industrializado",2,"Baratão",2.0);
		assertEquals("0. Queijo minas Dali, alimento industrializado, Preco: <Baratão, R$ 2,00;>", ItemPorUnidade.toString());
	}
}
