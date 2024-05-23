package catalog;

import java.util.ArrayList;
import java.util.List;

public class GenericCatalog<T extends LibraryItem> {
    private List<T> catalog;

    public GenericCatalog() {
        this.catalog = new ArrayList<>();
    }

    public void addItem(T item) {
        catalog.add(item);
        System.out.println(String.format("%s added to the library catalog.", item.getTitle()));
    }

    public void removeItem(int itemID) {
        for (T item : catalog) {
            if (item.getID() == itemID) {
                catalog.remove(item);
                System.out.println(String.format("%s removed from the library catalog.", item.getTitle()));
                return;
            }
        }
        System.out.println(String.format("ID: %d not found in the catalog.", itemID));
    }

    public T getItem(int itemID) {
        for (T item : catalog) {
            if (item.getID() == itemID) {
                return item;
            }
        }
        System.out.println(String.format("Item with ID %d not found in the catalog.", itemID));
        return null;
    }

    public void printCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("No items in the catalog.");
        } else {
            System.out.println("Catalog Items:");
            for (T item : catalog) {
                System.out.println(String.format("\t%s", item));
            }
        }
    }
}
