package unit7.models;

public class Student extends BaseEntity {
    private String name;
    private String email;

    // Constructor, getters, and setters
    public Student(int id, String name, String email) {
        this.setId(id);
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
