// EnrolledCourse.java

package Unit5;

import java.util.Date;

public class EnrolledCourse extends Course {
    private float grade;
    private Date dateEnrolled;

    public EnrolledCourse(Course course) {
        super(course.getCourseCode(), course.getName(), course.getMaxCapacity());

        this.grade = 0.0f;
        this.dateEnrolled = new Date();
    }

    public float getGrade() {
        return grade;
    }

    public String getGradeAsString() {
        if (grade >= 90.0f) {
            return "A";
        } else if (grade >= 80.0f) {
            return "B";
        } else if (grade >= 70.0f) {
            return "C";
        } else if (grade >= 60.0f) {
            return "D";
        } else {
            return "F";
        }
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public Date getDateEnrolled() {
        return dateEnrolled;
    }
}
