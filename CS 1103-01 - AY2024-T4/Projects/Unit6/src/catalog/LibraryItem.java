package catalog;

public class LibraryItem {
    private int id;
    private String title;

    private String author;

    public LibraryItem(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
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

    @Override
    public String toString() {
        return String.format("ID: %d, Title: %s, Author: %s", id, title, author);
    }
}
