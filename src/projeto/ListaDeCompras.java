package projeto;

import java.time.LocalDateTime;
import java.util.HashMap;
/**
 * Classe que representa um objeto Lista, guarda e manipula as compras cadastradas no sistema.
 * 
 * @author Victor Braga, Cleciana Santana
 */
public class ListaDeCompras {

	/**
	 * Mapa de Compras de uma Lista onde o Id de um Item é a chave, e o valor é um objeto Compra
	 */
	private HashMap<Integer, Compra> colecaoCompras;
	/**
	 * Guarda as informacoes data/hora em que a Lista foi criada
	 */
	private LocalDateTime data;
	/**
	 * String que descreve uma lista. Ex: 'Feira quinzenal'
	 */
	private String descricao;
	/**
	 * Após a finalizacao de uma Lista , indica em que Estabelecimento foram realizadas as compras.
	 */
	private String localDaCompra;
	/**
	 * Após a finalizacao de uma Lista , indica o valor total das compras.
	 */
	private double valorFinalCompra;
	
	
	/**
	 * Construtor, instancia um objeto ListaDECompras. Recebe uma descricao(String).
	 * 
	 * @param descricao
	 * 			String que descreve uma lista. Ex: 'Feira quinzenal'
	 */
	public ListaDeCompras(String descricao) {
		if (descricao.trim().isEmpty() || descricao == null) {
			throw new IllegalArgumentException("descritor nao pode ser vazio ou nulo.");
		}
		this.descricao = descricao;
		this.data = LocalDateTime.now();
	}

	/**
	 * Getter de localDaCompra
	 * @return
	 * 			Retorna uma String que informa o local onde foram feitas as compras
	 */
	public String getLocaDaCompra() {
		return localDaCompra;
	}

	/**
	 * Setter para locaDaCompra. Lanca uma excecao caso o local de compra seja vazio ou nulo.
	 * @param locaDaCompra
	 */
	public void setLocaDaCompra(String localDaCompra) {
		if (localDaCompra.trim().isEmpty() || localDaCompra == null) {
			throw new IllegalArgumentException("local nao pode ser vazio ou nulo.");
		}
		this.localDaCompra = localDaCompra;
	}

	/**
	 * Getter de ValorFinal
	 * @return
	 * 			Retorna um double que indica o valor total das compras da Lista.
	 */
	public double getValorFinalCompra() {
		return valorFinalCompra;
	}

	/**
	 * Altera o valor total das compras da lista.
	 * 
	 * @param valorFinalCompra
	 * 			double que indica o valor total das compras
	 */
	public void setValorFinalCompra(double valorFinalCompra) {
		if (valorFinalCompra <= 0) {
			throw new IllegalArgumentException("valor final da lista invalido.");
		}
		this.valorFinalCompra = valorFinalCompra;
	}

	/**
	 * Getter de informacao sobre data/hora de criacao da Lista
	 * @return
	 * 			Informacoes sobre data/hora de criacao da lista.
	 */
	public LocalDateTime getData() {
		return data;
	}
	
	/**
	 * Adiciona um objeto Compra na colecao de compras de uma Lista.
	 * 
	 * @param quantidade
	 * 			Quantidade de itens da compra.
	 * @param item
	 * 			Item associado a compra.
	 */
	public void adicionarCompra(int quantidade, Item item) {
		Compra novaCompra = new Compra(quantidade, item);
		this.colecaoCompras.put(item.getIdItem(), novaCompra);
	}
	
	/**
	 * Pesquisa uma compra na lista, lanca excecoes caso a compra nao exista ou 
	 * o id do Item associado seja invalido.
	 * 
	 * @param idNumerico
	 * 			Identificador do Item que esta associado a compra.
	 * @return
	 * 			Retorna a String representacao da compra.
	 */
	public String pesquisaCompra(int idNumerico) {
		Compra novaCompra = this.colecaoCompras.get(idNumerico);
		if (novaCompra == null) {
			throw new NullPointerException("compra nao encontrada na lista.");
		}
		if (idNumerico < 0) {
			throw new IllegalArgumentException("item id invalido.");
		}
		return novaCompra.toString();
	}
	
	/**
	 * 	Retorna a String representacao de uma compra na lista. Caso a compra
	 *  nao exista retorna uma String vazia.
	 * 
	 * @param posicaoItem
	 * 			Inteiro que indentifica a compra desejada.
	 */
	public String retornaCompra(int posicaoItem) {
		Compra compra = this.colecaoCompras.get(posicaoItem);
		if (compra == null) {
			return "";
		}
		return compra.toString();
	}

	/**
	 * Metodo que atualiza a quantidade de itens de uma compra. Lanca excecao caso o item
	 * nao exista ou a operacao recebida seja invalida.
	 * 
	 * @param itemId
	 * 			Identificador do Item da compra
	 * @param operacao
	 * 			Operacao a ser efetuada na quantidade. Pode ser "adiciona" ou "diminui".
	 * @param quantidade
	 * 			Quantidade de Item a ser acrescida ou retirada da compra.
	 */
	public void atualizaCompra(int itemId, String operacao, int quantidade) {
		Compra compraAux = this.colecaoCompras.get(itemId);
		
		if (compraAux == null) {
			throw new NullPointerException("item nao cadastrado.");
		}
		if (operacao.equals("adiciona")) {
			compraAux.setQuantidade(compraAux.getQuantidade() + quantidade);
			
		} else if (operacao.equals("diminui")) {
			compraAux.setQuantidade(compraAux.getQuantidade() - quantidade);
		} else {
			throw new IllegalArgumentException("operacao invalida.");
		}		
	}

	/**
	 * Deleta a compra identificada pelo Id da Lista.
	 * 
	 * @param identificador
	 * 			Identifica a compra.
	 */
	public void deletaCompra(int identificador) {
		this.colecaoCompras.remove(identificador);
	}
	
	/**
	 * Retorna a representacao de uma Lista De Compras.
	 */
	public String toString() {
		return this.descricao;
	}
}
