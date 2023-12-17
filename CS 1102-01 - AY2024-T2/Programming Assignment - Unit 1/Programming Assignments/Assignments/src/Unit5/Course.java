package Unit5;

/**
 * The Course class represents a course offered at the university.
 * It includes information about the course code, name, maximum capacity,
 * and the current number of enrolled students.
 */
public class Course {
    private String courseCode;
    private String name;
    private int maxCapacity;
    private int enrolledStudents;

    /**
     * Constructor for the Course class.
     *
     * @param courseCode  the unique code for the course.
     * @param name        the name of the course.
     * @param maxCapacity the maximum number of students that can enroll in the
     *                    course.
     */
    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = 0;
    }

    /**
     * Gets the course code.
     *
     * @return the course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Gets the course name.
     *
     * @return the name of the course.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the maximum capacity of the course.
     *
     * @return the maximum capacity.
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Gets the current number of enrolled students in the course.
     *
     * @return the number of enrolled students.
     */
    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    /**
     * Increments the number of enrolled students by one.
     * This method should be called when a new student enrolls in the course.
     */
    public void incrementEnrolledStudents() {
        if (enrolledStudents < maxCapacity) {
            enrolledStudents++;
        } else {
            System.out.println("Course is full, Cannot enroll any more students.");
        }
    }
}
