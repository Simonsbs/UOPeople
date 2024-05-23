package catalog;

public class LibraryItem {
    private int id;
    private String title;
    private String author;
    private int publishedYear;
    private String genre;

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
        return String.format("ID: %d, Title: %s, Author: %s, Published Year: %d, Genre: %s", id, title, author,
                publishedYear, genre);
    }
}
