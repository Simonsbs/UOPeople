package catalog;

/**
 * Represents a DVD in the library catalog.
 */
public class DVD extends LibraryItem {
    private int duration;

    /**
     * Constructor for creating a DVD instance.
     *
     * @param id            The ID of the DVD.
     * @param title         The title of the DVD.
     * @param author        The director of the DVD.
     * @param publishedYear The year the DVD was published.
     * @param genre         The genre of the DVD.
     * @param duration      The duration of the DVD in minutes.
     */
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
        return String.format("%s\n  Type: DVD\n  Duration: %d minutes", super.toString(), duration);
    }
}
