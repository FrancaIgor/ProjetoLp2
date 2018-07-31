package projeto.lista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import projeto.ComparatorCategoria;
import projeto.ComparatorData;
import projeto.ComparatorDescrLista;
import projeto.ComparatorNomeCompra;
import projeto.item.Item;
/**
 * Classe que controla as Listas de Compras criadas, pode adicionar e remover listas e compras, atualizar compras
 * e pesquisar por listas ou compras especificas.
 * 
 * @author Victor Braga, Cleciana Santana.
 */
public class ControllerListaCompras {

	/**
	 * Mapa que guarda as Listas cadastradas no sistema.
	 */
	private Map<String, ListaDeCompras> colecaoDeListas = new HashMap<String, ListaDeCompras>();

	/**
	 * Metodo que cria uma lista de compras recebendo sua descricao e adiciona essa
	 * lista à uma colecao de listas. Lanca uma excecao caso a descricao seja nula ou vazia.
	 */
	public String adicionaListaDeCompras(String descricao) {
		try {
			if (this.colecaoDeListas.containsKey(descricao)) {
				throw new IllegalArgumentException("Erro na criacao de lista de compras: Lista já existe.");
			}
			ListaDeCompras listaNova = new ListaDeCompras(descricao);
			
			this.colecaoDeListas.put(descricao, listaNova);
			
		} catch (Exception a) {
			throw new IllegalArgumentException("Erro na criacao de lista de compras: " + a.getMessage());
		}
		return this.colecaoDeListas.get(descricao).toString();
	}
	
	/**
	 * Método que retorna a descricao de uma lista de compras se ela estiver cadastrada.
	 * @param descricao
	 * 			descricao da lista de compras
	 */
	public String pesquisaListaDeCompras(String descricao) {
		if (descricao.trim().isEmpty() || descricao == null) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}
		if (this.colecaoDeListas.containsKey(descricao)) {
			return descricao;
		}
		throw new NullPointerException("Erro na pesquisa de compra: lista de compras nao existe.");
	}
	
	/**
	 * 
	 * @param data
	 * @param idNumerico
	 * @return
	 */
	public String pesquisaListaDeComprasDataCriacao(LocalDate data,int idNumerico) {
		ArrayList<ListaDeCompras> listasFeitas = new ArrayList<ListaDeCompras>();
		
		for (ListaDeCompras L : colecaoDeListas.values()) {
			if (L.getData() == data) {
				listasFeitas.add(L);
			}
		}
		
		return listasFeitas.get(idNumerico).getLocaDaCompra() + listasFeitas.get(idNumerico).getData();
	}

	/**
	 * 
	 * @param idItem
	 * @param posicao
	 * @return
	 */
	public String pesquisaListaPorIdItem(int idItem, int posicao) {
		ArrayList<ListaDeCompras> produtosComprados = new ArrayList<ListaDeCompras>();
		
		for (ListaDeCompras compras : colecaoDeListas.values()) {
			if(compras.verificaItem(idItem)) {
				produtosComprados.add(compras);
			}
		}
		return produtosComprados.get(posicao).getData() + " - " + produtosComprados.get(posicao).getDescricao();
	}

	/**
	 * Retorna a String representacao de uma compra na lista. Caso a compra nao exista, retorna uma String vazia.
	 * 
	 * @param descricao
	 * 			Descricao da lista de compras
	 * @param idItem
	 * 			Id do item associado a compra
	 */
	public String pesquisaListaDeComprasDescricao(String descricao, int idNumerico) {
		
		if (this.colecaoDeListas.containsKey(descricao)) {
			return this.colecaoDeListas.get(descricao).pesquisaCompra(idNumerico);
		}
		throw new NullPointerException("Erro na pesquisa de lista: lista nao cadastrada.");
	}

	/**
	 * Método que adiciona uma compra a lista de compras, recebendo sua descricao, um
	 * objeto Item e a quantidade deste Item na lista. Lanca uma excecao se o item nao existe.
	 * 
	 * @param descricao
	 * 			Descricao da lista de compras
	 * @param quantidade
	 * 			Quantidade de Itens da compra
	 * @param item
	 * 			Item a ser comprado
	 */
	public void adicionarCompraALista(String descricao, int quantidade, Item item) {
		if (item == null) {
			throw new NullPointerException("Erro na compra de item: item nao existe no sistema.");
		}
		ListaDeCompras listaAux = this.colecaoDeListas.get(descricao);
		
		if (listaAux.verificaItem(item.getIdItem())) {
			throw new IllegalArgumentException("Erro na compra de item: compra ja existe.");
		}
		listaAux.adicionarCompra(quantidade, item);
	}
	
	/**
	 * Método que finaliza uma lista, quando o usuario realiza as compras.
	 * 
	 * @param descricao
	 * 			Descricao da lista de compras
	 * @param localDeCompra
	 * 			Estabelecimento em que foram realizadas as compras
	 * @param valorFinal
	 * 			Valor Total de todas as compras feitas em um local
	 */
	public void finalizarListaDeCompras(String descricao, String localDeCompra, double valorFinal) {
		if (descricao.trim().isEmpty() || descricao == null) {
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}
		try {
			this.colecaoDeListas.get(descricao).setLocaDaCompra(localDeCompra);
			this.colecaoDeListas.get(descricao).setValorFinalCompra(valorFinal);

		} catch (Exception c) {
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: " + c.getMessage());
		}
	}
	
	/**
	 * Método que retorna representacao String de uma compra caso esta esteja cadastrada na Lista
	 * 
	 * @param descricao
	 * 			Descricao da Lista que pode conter a compra
	 * @param idNumerico
	 * 			ID do Item desejado
	 * @return
	 * 			Retorna uma String representacao do Objeto Compra
	 */
	public String pesquisaCompraEmLista(String descricao, int idNumerico) {
		
		if (descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}
		if (idNumerico < 0) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: item id invalido.");
		}
		ListaDeCompras lista = this.colecaoDeListas.get(descricao);
		
		if (lista == null) {
			throw new NullPointerException("Erro na pesquisa de compra: lista nao encontrada.");
		}
		try {
			String saida = lista.pesquisaCompra(idNumerico);
			return saida;
			
		} catch (Exception b) {
			throw new NullPointerException("Erro na pesquisa de compra: " + b.getMessage());
		}
	}

	/**
	 * Metodo que atualiza a quantidade de itens de uma compra. Lanca excecao caso o item
	 * nao exista ou a operacao recebida seja invalida.
	 * 
	 * @param descritorLista
	 * 			Descritor da lista que contem a compra
	 * @param itemId
	 * 			Identificador do Item da compra
	 * @param operacao
	 * 			Operacao a ser efetuada na quantidade. Pode ser "adiciona" ou "diminui".
	 * @param quantidade
	 * 			Quantidade de Item a ser acrescida ou retirada da compra.
	 */
	public void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int quantidade) {
		
		if (!operacao.equals("adiciona") && !operacao.equals("diminui")) {
			
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}
		this.colecaoDeListas.get(descritorLista).atualizaCompra(itemId, operacao, quantidade);
	}
	
	/**
	 * Deleta, da Lista de compras, a que esta associada ao Item recebido.
	 * 
	 * @param descritorLista
	 * 			Descritor da Lista que contem a compra.
	 * @param item
	 * 			Item associado a compra que sera remoivda.
	 */
	public void deletaCompraDeLista(String descritorLista, Item item) {
		
		if (descritorLista.trim().isEmpty() || descritorLista == null) {
			throw new IllegalArgumentException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
		}
		if (item == null) {
			throw new NullPointerException("Erro na exclusao de compra: item nao existe no sistema.");
		}
		ListaDeCompras listaAux = this.colecaoDeListas.get(descritorLista);
		
		if (listaAux.retornaCompra(item.getIdItem()).equals("")) {
			throw new NullPointerException("Erro na exclusao de compra: compra nao encontrada na lista.");
		}
		listaAux.deletaCompra(item.getIdItem());
	}

	/**
	 * Ordena a lista de compra em dois niveis. Primeiro, por categoria, e entre itens de
	 * mesma categoria, usa a ordem alfabetica para ordenacao. Por ultimo, retorna a compra
	 * da posicao especificada, se esta existir na lista.
	 * 
	 * @param descritor
	 * 			Descritor da lista onde a compra esta.
	 * @param posicao
	 * 			Posicao da compra na lista
	 * @return
	 * 			String representacao uma compra na lista
	 */
	public String getItemLista(String descritor, int posicao) {
		Collection<Compra> compras = this.colecaoDeListas.get(descritor).getCompras().values();
		ArrayList<Compra> lista = new ArrayList<>(compras);
		
		if (posicao >= lista.size()) {
			return "";
		}
		
		Collections.sort(lista, new ComparatorCategoria().thenComparing(new ComparatorNomeCompra()));
		
		return lista.get(posicao).toString();
	}

	/**
	 * Retorna, dentre as listas criadas na data especificada, a que esta na 
	 * posicao passada apos ordenacao por ordem alfabetica.
	 * 
	 * @param data
	 * 			data de criacao das listas.
	 * @param posicaoLista
	 * 			posicao que a lista ocupa apos ordenacao.
	 * @return
	 * 			Retorna a descricao da lista, se existir.
	 */
	public String getItemListaPorData(String data, int posicaoLista) {

		ArrayList<ListaDeCompras> listasPorData = new ArrayList<>();		
		for (ListaDeCompras lista : this.colecaoDeListas.values()) {
			
			if (lista.getData().toString().equals(data)) {
				listasPorData.add(lista);
			}
		}
		Collections.sort(listasPorData);
		return listasPorData.get(posicaoLista).toString();
	}

	/**
	 * 
	 * @param id
	 * @param posicaoLista
	 * @return
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		
		ArrayList<ListaDeCompras> listas = new ArrayList<>();
		for (ListaDeCompras lista : this.colecaoDeListas.values()) {
			
			if (lista.verificaItem(id)) {
				listas.add(lista);
			}
		}
		Collections.sort(listas, new ComparatorData().thenComparing(new ComparatorDescrLista()));
		ListaDeCompras listaDesejada = listas.get(posicaoLista);
		
		return listaDesejada.getData().toString() + " - " + listaDesejada.getDescricao();
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public String pesquisaListaDeComprasPorData(String data) {
		
		String saida = "";
		try {
			if (validaData(data)) {
				saida = "Esse metodo deveria retornar o que afinal??";
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: " + e.getLocalizedMessage());
		}
		return saida;
	}
	
	/**
	 * Metodo auxiliar que verifica se uma data eh valida, ou seja, tem o formato dd/MM/yyyy
	 * 
	 * @param data
	 * 			String q representa a data
	 * @return
	 *  		True se data eh valida, false caso contrario.
	 */
	private boolean validaData(String data) {

		if (data.trim().isEmpty() || data == null) {
			throw new IllegalArgumentException("data nao pode ser vazia ou nula.");
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
			sdf.setLenient(false);
			sdf.parse(data);
			
			return true;
			
		} catch (ParseException a) {
			throw new IllegalArgumentException("data em formato invalido, tente dd/MM/yyyy");
		}
	}
	

	/**
	 * 
	 * @param id
	 * @return
	 */
	public String pesquisaListasDeComprasPorItem(int id) {

		if (id < 0) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: id invalido.");
		}
		ArrayList<ListaDeCompras> listas = new ArrayList<>();
		for (ListaDeCompras lista : this.colecaoDeListas.values()) {
			
			if (lista.verificaItem(id)) {
				listas.add(lista);
			}
		}
		if (listas.isEmpty()) {
			throw new NullPointerException("Erro na pesquisa de compra: compra nao encontrada na lista.");
		}
		return listas.toString(); // Seraaar?
	}
}
