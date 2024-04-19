package unit7.models;

public class Enrollment extends BaseEntity {
    private int studentId;
    private int courseId;

    // Constructor, getters, and setters
    public Enrollment(int id, int studentId, int courseId) {
        this.setId(id);
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
