package catalog;

public class DVD extends LibraryItem {
    private int duration; // Duration in minutes

    public DVD(int id, String title, String author, int duration) {
        super(id, title, author);
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
        return String.format("DVD [ID: %d, Title: %s, Director: %s, Duration: %d minutes]", getID(), getTitle(),
                getAuthor(), duration);
    }
}
