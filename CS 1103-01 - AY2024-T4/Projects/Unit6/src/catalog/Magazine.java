package catalog;

public class Magazine extends LibraryItem {
    private int issueNumber;

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
        return String.format(
                "Magazine [ID: %d, Title: %s, Editor: %s, Published Year: %d, Genre: %s, Issue Number: %d]", getID(),
                getTitle(), getAuthor(), getPublishedYear(), getGenre(), issueNumber);
    }
}