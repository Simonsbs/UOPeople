// Course.java
package Unit5;

import java.util.Scanner;

/**
 * Represents a course offered at the university.
 * This class includes information about the course code, name, maximum
 * capacity, and the current number of enrolled students.
 */
public class Course {
    private String courseCode;
    private String name;
    private int maxCapacity;
    private int enrolledStudents;

    /**
     * Constructor for the Course class.
     * Initializes a new course with the specified code, name, and maximum capacity.
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
     * Increments the number of enrolled students by one, if the course is not full.
     */
    public void incrementEnrolledStudents() {
        if (canEnroll()) {
            enrolledStudents++;
        } else {
            System.out.println("Course is full, cannot enroll any more students.");
        }
    }

    /**
     * Edits the course's information.
     *
     * @param newName     the new name of the course
     * @param newCapacity the new maximum capacity of the course
     */
    public void editCourseInfo(String newName, int newCapacity) {
        this.name = newName;
        this.maxCapacity = newCapacity;
    }

    public static Course addNewCourse(Scanner scanner) {
        System.out.print("Enter course code: ");
        String code = scanner.next();
        scanner.nextLine();

        System.out.print("Enter course name: ");
        String name = scanner.nextLine();

        int capacity = Utils.readPositiveInt(scanner, "Enter max capacity: ");
        return new Course(code, name, capacity);
    }

    public String enrollStudent(Student student) {
        if (canEnroll()) {
            incrementEnrolledStudents();
            return "Student enrolled in " + this.name + " successfully.";
        }
        return "Cannot enroll in " + this.name + ", course is full.";
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
