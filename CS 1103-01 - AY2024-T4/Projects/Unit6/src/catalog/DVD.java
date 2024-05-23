package catalog;

public class DVD extends LibraryItem {
    private int duration;

    public DVD(int id, String title, String author, int publishedYear, String genre, int duration) {
        super(id, title, author, publishedYear, genre);
        if (!Tools.isValidDuration(duration)) {
            throw new IllegalArgumentException("Invalid duration. Duration must be greater than 0.");
        }
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format(
                "DVD [ID: %d, Title: %s, Director: %s, Published Year: %d, Genre: %s, Duration: %d minutes]", getID(),
                getTitle(), getAuthor(), getPublishedYear(), getGenre(), duration);
    }
}
