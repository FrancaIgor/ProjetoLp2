package item;

import java.util.Comparator;

public class ComparatorNome implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        return item1.toString().compareTo(item2.toString());
    }
}
