package catalog;

public class CustomExceptions {

    public static class ItemAlreadyExistsException extends RuntimeException {
        public ItemAlreadyExistsException(String message) {
            super(message);
        }
    }

    public static class ItemNotFoundException extends RuntimeException {
        public ItemNotFoundException(String message) {
            super(message);
        }
    }
}
