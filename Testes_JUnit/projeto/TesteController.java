package projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.ControllerItens;
import projeto.Item;
import projeto.ItemPorQuantidade;
import projeto.ItemPorQuilo;
import projeto.ItemPorUnidade;
/**
 * Classe de testes para ControllerItens
 * @author Rostanth
 *
 */
public class TesteController {

	private ControllerItens controllerItem = new ControllerItens();
	
	@Before
	public void CriaItem() {
		Item itemPorQtd = new ItemPorQuantidade("Pasta de dente", "higiene pessoal", "Baratão", "ml", 300, 2.00);
		Item itemPorQuilo = new ItemPorQuilo("batata", "alimentos nao industrializados", "Baratao", 1.50, 1.2);
		Item itemPorUnidade = new ItemPorUnidade("Queijo minas Dali", "alimentos industrializados", 2, "Baratão", 2.0);
	}
	
	@Test
	public void testadicionaItemPorQtd() {
		assertEquals("CADASTRO REALIZADO",controllerItem.adicionaItemPorQtd("salgadinho", "produto industrializado", 3, "kg", "rede Lascados", 2.50));
		
	}
	
	@Test
	public void testItemPorQuilo() {
		assertEquals("CADASTRO REALIZADO", controllerItem.adicionaItemPorQuilo("batata", "produto não industrializado", 2.5, "feira da prata", 3.50));
	}
	
	@Test
	public void testItemPorUnidade() {
		assertEquals("CADASTRO REALIZADO", controllerItem.adicionaItemPorUnidade("ovo", "não industralizados", 3, "mercado do seu zé", 0.75));
	}
	
	@Test
	public void testAtualizaItem() {
		controllerItem.atualizaItem(1, "nome","batata doce");
		
	}
	
	@Test
	public void testadicionaPrecoItem() {
		controllerItem.adicionaPrecoItem(1, "rede lascados", 2.50);
	}
	
	@Test 
	public void testDeletaItem() {
		controllerItem.deletaItem("1");
	}

}
