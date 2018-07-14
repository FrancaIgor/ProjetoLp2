package projeto;

import java.util.Comparator;

public class ComparatorNome implements Comparator<Item> {
    @Override
    public int compare(Item c1, Item c2) {
        return c1.getNome().compareTo(c2.getNome());
    }
}
