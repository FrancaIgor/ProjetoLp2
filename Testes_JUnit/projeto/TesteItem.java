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
		ItemPorQuilo item = new ItemPorQuilo("batata","alimentos nao industrializados", "Baratao", 1.50,1.2);
		assertEquals("", item.toString());
		// ItemPorQuilo novoitem = new ItemPorQuilo("laranja","alimentos nao industrializados", "Baratao",2.30,2.0);
	}
	
	@Test
	public void testExistenciaItemPorQuilo() {
		assertNotNull(itemQuilo);
		
	}

	@Test
	public void testidNumerico() {
		assertEquals(1, itemQuilo.getIdItem());
	}
	
	@Test
	public void testEqualsItem() {
		assertNotEquals(itemQuilo.toString(), novoItemQuilo.toString());
	}
	
	@Test
	public void testCriaItemPorQtd() {
		itemPorQtd = new ItemPorQuantidade("Pasta de dente", "higiene pessoal","Baratão", "ml",300,2.00);
		
	}
	
	@Test
	public void testExistenciaItemPorQtd() {
		assertNotNull(itemPorQtd);
	}
	
	@Test
	public void testCriaItemPorUnidade() {
		ItemPorUnidade ItemPorUnidade = new ItemPorUnidade("Queijo minas Dali", "alimentos industrializados",2,"Baratão",2.0);
		assertEquals("", ItemPorUnidade.toString());
	}
	

}
