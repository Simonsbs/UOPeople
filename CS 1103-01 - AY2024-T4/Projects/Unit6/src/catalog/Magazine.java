package catalog;

public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(int id, String title, String author, int issueNumber) {
        super(id, title, author);
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
        return String.format("Magazine [ID: %d, Title: %s, Editor: %s, Issue Number: %d]", getID(), getTitle(),
                getAuthor(), issueNumber);
    }
}
