package projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.item.ControllerItens;

/**
 * Classe de testes para ControllerItens
 * 
 * @author Rostanth
 */
public class TesteController {

	private ControllerItens controllerItem = new ControllerItens();


	@Before
	public void adicionaItem() {
		this.controllerItem.adicionaItemPorQtd("Pasta de dente", "higiene pessoal", 200, "g", "Baratao", 2.20);
		this.controllerItem.adicionaItemPorQuilo("batata", "alimento nao industrializado", 1.50, "Baratao", 1.2);
		this.controllerItem.adicionaItemPorUnidade("Queijo minas Dali", "alimento industrializado", 2, "Baratão", 2.0);
	}

	@Test
	public void testadicionaItemPorQtd() {
		assertEquals(12, this.controllerItem.adicionaItemPorQtd("salgadinho", "alimento industrializado", 3, "kg", "rede Lascados", 2.50));		
	}
	
	@Test
	public void testItemPorQuilo() {
		assertEquals(4, this.controllerItem.adicionaItemPorQuilo("batata inglesa", "alimento nao industrializado", 2.5, "feira da prata", 3.50));
	}
	
	@Test
	public void testItemPorUnidade() {
		assertEquals(8, this.controllerItem.adicionaItemPorUnidade("ovo", "alimento nao industrializado", 3, "mercado do seu zé", 0.75));
	}
}

