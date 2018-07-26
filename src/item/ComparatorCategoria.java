package item;

import java.util.Comparator;

public class ComparatorCategoria implements Comparator<Compra>{

	@Override
	public int compare(Compra compra1, Compra compra2) {
		CategoriasEnum categoria1 = compra1.getItem().getCategoriasEnum();
		CategoriasEnum categoria2 = compra2.getItem().getCategoriasEnum();
		
		return categoria1.compareTo(categoria2);
	}


}
