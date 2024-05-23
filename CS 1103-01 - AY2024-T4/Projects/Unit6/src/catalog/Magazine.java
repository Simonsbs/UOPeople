package catalog;

/**
 * Represents a Magazine in the library catalog.
 */
public class Magazine extends LibraryItem {
    private int issueNumber;

    /**
     * Constructor for creating a Magazine instance.
     *
     * @param id            The ID of the magazine.
     * @param title         The title of the magazine.
     * @param author        The editor of the magazine.
     * @param publishedYear The year the magazine was published.
     * @param genre         The genre of the magazine.
     * @param issueNumber   The issue number of the magazine.
     */
    public Magazine(int id, String title, String author, int publishedYear, String genre, int issueNumber) {
        super(id, title, author, publishedYear, genre);
        if (!Tools.isValidIssueNumber(issueNumber)) {
            throw new IllegalArgumentException("Invalid issue number. Issue number must be greater than 0.");
        }
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String toString() {
        return String.format("%s\n  Type: Magazine\n  Issue Number: %d", super.toString(), issueNumber);
    }
}
