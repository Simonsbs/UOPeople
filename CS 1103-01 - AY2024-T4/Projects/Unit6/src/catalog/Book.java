package catalog;

public class Book extends LibraryItem {
    private int pages;

    public Book(int id, String title, String author, int pages) {
        super(id, title, author);
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
        return String.format("Book [ID: %d, Title: %s, Author: %s, Pages: %d]", getID(), getTitle(), getAuthor(),
                pages);
    }
}
