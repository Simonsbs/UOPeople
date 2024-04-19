package unit7.models;

public class Grade extends BaseEntity {
    private int studentId;
    private int courseId;
    private String grade;

    // Constructor, getters, and setters
    public Grade(int id, int studentId, int courseId, String grade) {
        this.setId(id);
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
