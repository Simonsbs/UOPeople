package catalog;

public class Book extends LibraryItem {
    private int pages;

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
        return String.format("Book [ID: %d, Title: %s, Author: %s, Published Year: %d, Genre: %s, Pages: %d]", getID(),
                getTitle(), getAuthor(), getPublishedYear(), getGenre(), pages);
    }
}
