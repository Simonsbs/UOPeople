package catalog;

/**
 * Represents a generic library item.
 */
public class LibraryItem {
    private int id;
    private String title;
    private String author;
    private int publishedYear;
    private String genre;

    /**
     * Constructor for creating a LibraryItem instance.
     *
     * @param id            The ID of the item.
     * @param title         The title of the item.
     * @param author        The author of the item.
     * @param publishedYear The year the item was published.
     * @param genre         The genre of the item.
     */
    public LibraryItem(int id, String title, String author, int publishedYear, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.genre = genre;
    }

    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return String.format("Library Item\n  ID: %d\n  Title: %s\n  Author: %s\n  Published Year: %d\n  Genre: %s",
                id, title, author, publishedYear, genre);
    }
}
