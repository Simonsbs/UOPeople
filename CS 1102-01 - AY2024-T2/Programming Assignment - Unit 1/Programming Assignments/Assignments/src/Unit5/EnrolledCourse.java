// EnrolledCourse.java
package Unit5;

import java.util.Date;

/**
 * Represents a course in which a student is enrolled.
 * This class extends the Course class by adding a grade and the date of
 * enrollment.
 */
public class EnrolledCourse extends Course {
    private float grade;
    private Date dateEnrolled;

    /**
     * Constructor for EnrolledCourse class.
     * Initializes an enrolled course based on a given Course object.
     * Sets the initial grade to 0.0 and the enrollment date to the current date.
     *
     * @param course The Course object to base the EnrolledCourse on
     */
    public EnrolledCourse(Course course) {
        super(course.getCourseCode(), course.getName(), course.getMaxCapacity());
        this.grade = 0.0f;
        this.dateEnrolled = new Date();
    }

    /**
     * Gets the grade of the student in this course.
     *
     * @return The numerical grade
     */
    public float getGrade() {
        return grade;
    }

    /**
     * Sets the grade of the student for this course.
     *
     * @param grade The numerical grade to set
     */
    public void setGrade(float grade) {
        // Check if the grade is within the valid range
        if (grade >= 0.0f && grade <= 100.0f) {
            this.grade = grade;
        } else {
            System.out.println("Invalid grade. Grade must be between 0.0 and 100.0.");
        }
    }

    /**
     * Gets the date when the student enrolled in the course.
     *
     * @return The date of enrollment
     */
    public Date getDateEnrolled() {
        return dateEnrolled;
    }

    /**
     * Prints the details of the enrolled course including the grade.
     */
    public void printEnrolledCourseDetails() {
        System.out.println("Course: " + getName() +
                ", Code: " + getCourseCode() +
                ", Enrolled On: " + dateEnrolled +
                ", Grade: " + grade);
    }
}
