package Unit5;

import java.util.Date;

public class EnrolledCourse {
    private Course course;
    private float grade;
    private Date startDate;

    public EnrolledCourse(Course course) {
        this.course = course;
        this.grade = 0.0f;

        this.startDate = new Date();
    }
}
