package unit7.models;

public class Course extends BaseEntity {
    private String courseName;

    // Constructor, getters, and setters
    public Course(int id, String courseName) {
        this.setId(id);
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
