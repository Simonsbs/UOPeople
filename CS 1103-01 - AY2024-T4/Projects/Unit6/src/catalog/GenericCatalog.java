package catalog;

import java.util.ArrayList;
import java.util.List;

public class GenericCatalog<T extends LibraryItem> {
    private List<T> catalog;

    public GenericCatalog() {
        this.catalog = new ArrayList<>();
    }

    public void addItem(T item) {
        if (catalog.stream().anyMatch(existingItem -> existingItem.getID() == item.getID())) {
            throw new CustomExceptions.ItemAlreadyExistsException(
                    String.format("Item with ID %d already exists in the catalog.", item.getID()));
        }
        catalog.add(item);
        System.out.println(String.format("%s added to the library catalog.", item.getTitle()));
    }

    public void removeItem(int itemID) {
        T item = catalog.stream()
                .filter(existingItem -> existingItem.getID() == itemID)
                .findFirst()
                .orElseThrow(() -> new CustomExceptions.ItemNotFoundException(
                        String.format("Item with ID %d not found in the catalog.", itemID)));
        catalog.remove(item);
        System.out.println(String.format("%s removed from the library catalog.", item.getTitle()));
    }

    public T getItem(int itemID) {
        return catalog.stream()
                .filter(item -> item.getID() == itemID)
                .findFirst()
                .orElseThrow(() -> new CustomExceptions.ItemNotFoundException(
                        String.format("Item with ID %d not found in the catalog.", itemID)));
    }

    public List<T> getItems() {
        return catalog;
    }

    public void printCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("No items in the catalog.");
        } else {
            System.out.println("Catalog Items:");
            catalog.forEach(item -> System.out.println(String.format("-> %s", item)));
        }
    }
}
