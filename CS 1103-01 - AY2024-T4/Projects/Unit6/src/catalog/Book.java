package catalog;

/**
 * Represents a Book in the library catalog.
 */
public class Book extends LibraryItem {
    private int pages;

    /**
     * Constructor for creating a Book instance.
     *
     * @param id            The ID of the book.
     * @param title         The title of the book.
     * @param author        The author of the book.
     * @param publishedYear The year the book was published.
     * @param genre         The genre of the book.
     * @param pages         The number of pages in the book.
     */
    public Book(int id, String title, String author, int publishedYear, String genre, int pages) {
        super(id, title, author, publishedYear, genre);
        if (!Tools.isValidPages(pages)) {
            throw new IllegalArgumentException("Invalid pages. Pages must be greater than 0.");
        }
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return String.format("%s\n  Type: Book\n  Pages: %d", super.toString(), pages);
    }
}
