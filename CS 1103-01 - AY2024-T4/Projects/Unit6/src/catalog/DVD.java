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
        return String.format("%s\n  Type: DVD\n  Duration: %d minutes", super.toString(), duration);
    }
}
