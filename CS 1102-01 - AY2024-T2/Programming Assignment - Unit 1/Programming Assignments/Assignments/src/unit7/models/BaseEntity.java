package unit7.models;

public abstract class BaseEntity {
    protected int id; // Unique identifier

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
