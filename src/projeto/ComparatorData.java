package projeto;

import java.util.Comparator;

import projeto.lista.ListaDeCompras;

public class ComparatorData implements Comparator<ListaDeCompras> {


	@Override
	public int compare(ListaDeCompras lista1, ListaDeCompras lista2) {
		
		if (lista1.getData().isBefore(lista2.getData())) {
			return -1;
		}
		if (lista1.getData().isAfter(lista2.getData())) {
			return 1;
		}
		return 0;
	}

}
