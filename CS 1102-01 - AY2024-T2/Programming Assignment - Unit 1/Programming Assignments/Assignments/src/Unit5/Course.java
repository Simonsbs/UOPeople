// Course.java
package Unit5;

import java.util.Scanner;
import java.util.ArrayList;

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
        // Check if the course is not full
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
    private void editCourseInfo(String newName, int newCapacity) {
        this.name = newName;
        this.maxCapacity = newCapacity;
    }

    /**
     * Adds a new course to the system.
     *
     * @param scanner the scanner to read input from
     * @return the new course
     */
    public static Course addNewCourse(Scanner scanner) {
        System.out.print("Enter course code: ");
        String code = scanner.next();
        scanner.nextLine();

        System.out.print("Enter course name: ");
        String name = scanner.nextLine();

        int capacity = Utils.readPositiveInt(scanner, "Enter max capacity: ");
        return new Course(code, name, capacity);
    }

    public static void editCourseInfo(Scanner scanner, ArrayList<Course> courses) {
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        scanner.nextLine();

        Course course = findCourseByCode(courseCode, courses);
        if (course != null) {
            System.out.print("Enter new course name: ");
            String newName = scanner.nextLine();

            int newCapacity = Utils.readPositiveInt(scanner, "Enter new max capacity: ");
            course.editCourseInfo(newName, newCapacity);
            System.out.println("Course information updated successfully.");
        } else {
            System.out.println("Invalid course code.");
        }
    }

    private static Course findCourseByCode(String code, ArrayList<Course> courses) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Enrolls a student in the course.
     *
     * @param student the student to enroll
     * @return a message indicating whether the student was enrolled successfully
     */
    public String enrollStudent(Student student) {
        // Check if the course is not full
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
