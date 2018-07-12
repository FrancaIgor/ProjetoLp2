package projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteItem {

	private Item itemQuilo;
	private Item novoItemQuilo;
	private Item itemPorQtd;
	private Item itemPorUnidade;
	
	@Before
	public void CriaItemPorQuilo() {
		ItemPorQuilo item = new ItemPorQuilo("batata",1.50,1.2);
		ItemPorQuilo novoitem = new ItemPorQuilo("laranja",2.30,2.0);
	}
	
	@Test
	public void testExistenciaItemPorQuilo() {
		assertNotNull(itemQuilo);
		
	}
	@Test
	public void testeCalculaPreco() {
		assertEquals(1.50*1.2, itemQuilo.calculaPreco());
	}
	
	
	@Test
	public void testidNumerico() {
		assertEquals(1, itemQuilo.getIdNumerico());
	}
	
	@Test
	public void testEqualsItem() {
		assertNotEquals(itemQuilo.toString(), novoItemQuilo.toString());
	}
	
	@Test
	public void testCriaItemPorQtd() {
		ItemPorQtd itemPorQtd = new ItemPorQtd("salgadinho",2.50,3);
		
	}
	
	@Test
	public void testExistenciaItemPorQtd() {
		assertNotNull(itemPorQtd);
	}
	
	@Test
	public void testCalculaPrecoItemPorQtd() {
		assertEquals(2.50, itemPorQtd.calculaPreco());
	}
	
	@Test
	public void testCriaItemPorUnidade() {
		ItemPorUnidade ItemPorUnidade = new ItemPorUnidade("1","caixa de leite", 3.50); 
	}
	

}
