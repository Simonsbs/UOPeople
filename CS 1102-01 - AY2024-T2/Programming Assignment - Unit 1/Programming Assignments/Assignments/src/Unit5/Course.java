// Course.java
package Unit5;

/**
 * Represents a course offered at the university.
 * This class includes information about the course code, name, maximum
 * capacity,
 * and the current number of enrolled students.
 */
public class Course {
    private String courseCode;
    private String name;
    private int maxCapacity;
    private int enrolledStudents;

    /**
     * Constructor for the Course class.
     * Initializes a new course with the specified code, name, and maximum capacity.
     * Initially, there are no enrolled students.
     *
     * @param courseCode  the unique code for the course
     * @param name        the name of the course
     * @param maxCapacity the maximum number of students that can enroll in the
     *                    course
     */
    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = 0;
    }

    /**
     * Checks if students can still enroll in the course.
     *
     * @return true if the current number of enrolled students is less than the
     *         maximum capacity, false otherwise
     */
    public boolean canEnroll() {
        return enrolledStudents < maxCapacity;
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
     * Increments the number of enrolled students by one, if the course is not full.
     * Displays a message if the course has reached its maximum capacity.
     */
    public void incrementEnrolledStudents() {
        if (enrolledStudents < maxCapacity) {
            enrolledStudents++;
        } else {
            System.out.println("Course is full, Cannot enroll any more students.");
        }
    }

    /**
     * Prints the course info to the console.
     */
    public void print() {
        System.out.println("Code: " + courseCode +
                ", Name: " + name +
                ", Capacity: " + maxCapacity +
                ", Enrolled: " + enrolledStudents +
                ", Percentage Full: " + (enrolledStudents * 100 / maxCapacity) + "%");
    }
}
