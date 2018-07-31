package projeto;

import java.util.Comparator;

import projeto.lista.ListaDeCompras;

public class ComparatorDescrLista implements Comparator<ListaDeCompras> {

	@Override
	public int compare(ListaDeCompras lista1, ListaDeCompras lista2) {
		
		return lista1.getDescricao().compareToIgnoreCase(lista2.getDescricao());
	}

}
