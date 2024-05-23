package catalog;

/**
 * Contains custom exceptions used in the catalog.
 */
public class CustomExceptions {

    /**
     * Exception thrown when an item already exists in the catalog.
     */
    public static class ItemAlreadyExistsException extends RuntimeException {
        public ItemAlreadyExistsException(String message) {
            super(message);
        }
    }

    /**
     * Exception thrown when an item is not found in the catalog.
     */
    public static class ItemNotFoundException extends RuntimeException {
        public ItemNotFoundException(String message) {
            super(message);
        }
    }
}
