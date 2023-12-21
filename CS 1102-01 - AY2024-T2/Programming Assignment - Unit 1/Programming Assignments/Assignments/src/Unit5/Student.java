// Course.java
package Unit5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Student class represents a student.
 * It stores the student's personal info and the courses they are enrolled in,
 * along with the grades for each course.
 */
public class Student {
    private String name;
    private String ID;
    private ArrayList<EnrolledCourse> enrolledCourses;

    /**
     * Constructor for the Student class.
     *
     * @param name the name of the student
     * @param ID   the unique ID of the student
     */
    public Student(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.enrolledCourses = new ArrayList<>();
    }

    /**
     * Enrolls the student in a course.
     * Adds a new EnrolledCourse object to the enrolledCourses list if possible.
     *
     * @param course the course to enroll in
     * @return a message indicating the result of the enrollment attempt
     */
    public String enrollInCourse(Course course) {
        // Check if student is already enrolled in the course
        for (EnrolledCourse enrolledCourse : enrolledCourses) {
            if (enrolledCourse.getCourseCode().equals(course.getCourseCode())) {
                return "Student already enrolled in " + course.getName() + ".";
            }
        }

        String enrollmentMessage = course.enrollStudent(this);
        // If the enrollment was successful, add the course to the student's list of
        // enrolled courses
        if (enrollmentMessage.contains("successfully")) {
            EnrolledCourse enrolledCourse = new EnrolledCourse(course);
            enrolledCourses.add(enrolledCourse);
        }
        return enrollmentMessage;
    }

    /**
     * Sets a grade to the student for a specific course.
     *
     * @param course the course to set the grade to
     * @param grade  the grade to set
     */
    public void setCourseGrade(Course course, float grade) {
        // Loop through the student's enrolled courses
        for (EnrolledCourse enrolledCourse : enrolledCourses) {
            // If the student is enrolled in the specified course, set the grade
            if (enrolledCourse.getCourseCode().equals(course.getCourseCode())) {
                enrolledCourse.setGrade(grade);
                return;
            }
        }
        System.out.println("Student not enrolled in " + course.getName() + ".");
    }

    /**
     * Adds a new student to the system.
     * 
     * @param scanner          The scanner to read input from.
     * @param existingStudents The list of existing students to check for duplicate
     *                         IDs.
     * @return The newly created student.
     */
    public static Student addNewStudent(Scanner scanner, ArrayList<Student> existingStudents) {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        scanner.nextLine(); // Consume the rest of the line after reading name

        String id;
        // Loop until a valid ID is entered
        while (true) {
            System.out.print("Enter student ID: ");
            id = scanner.next();
            // Check if the ID is valid and unique
            if (!id.trim().isEmpty() && isUniqueId(id, existingStudents)) {
                break;
            } else {
                System.out.println("Invalid or duplicate ID. Please enter a unique ID.");
            }
        }
        return new Student(name, id);
    }

    public static void editStudentInfo(Scanner scanner, ArrayList<Student> students) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        Student student = findStudentById(studentId, students);
        if (student != null) {
            System.out.print("Enter new student name: ");
            String newName = scanner.next();
            student.setName(newName);
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Student findStudentById(String id, ArrayList<Student> students) {
        for (Student student : students) {
            if (student.getID().equals(id)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Checks if a given ID is unique.
     * 
     * @param id       The ID to check.
     * @param students The list of existing students to check against.
     * @return True if the ID is unique, false otherwise.
     */
    private static boolean isUniqueId(String id, ArrayList<Student> students) {
        // Loop through the list of existing students
        for (Student student : students) {
            // If the ID matches, return false
            if (student.getID().equals(id)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Edits the student's information.
     *
     * @param newName the new name of the student
     * @param newId   the new ID of the student
     */
    public void editStudentInfo(String newName, String newId) {
        this.name = newName;
        this.ID = newId;
    }

    /**
     * Gets the student's name.
     *
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the student's name.
     *
     * @param name the new name of the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the student's ID.
     *
     * @return the ID of the student
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the student's ID.
     *
     * @param ID the new ID of the student
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Calculates and returns the student's GPA.
     * GPA is computed as the average of grades in enrolled courses.
     *
     * @return the GPA of the student
     */
    public float getGPA() {
        // If the student is not enrolled in any courses, return 0.0
        if (enrolledCourses.isEmpty()) {
            return 0.0f;
        }
        float totalGrade = 0.0f;
        // Loop through the student's enrolled courses and add up the grades
        for (EnrolledCourse course : enrolledCourses) {
            // Add the grade to the total
            totalGrade += course.getGrade();
        }
        // Divide the total grade by the number of enrolled courses to get the average
        return totalGrade / enrolledCourses.size();
    }

    /**
     * Prints the student's info and final grade to the console.
     */
    public void printFinalGrade() {
        float gpa = this.getGPA();
        System.out.println("Student: " + name + " (ID: " + ID + ")");
        System.out.println("GPA: " + gpa + ", Grade: " + getGradeAsString(gpa));
    }

    /**
     * Converts a float grade to a string grade.
     * 
     * @param grade The grade to convert.
     * @return The string representation of the grade.
     */
    private static String getGradeAsString(float grade) {
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

    /**
     * Prints the student's information to the console.
     */
    public void print() {
        System.out.println("ID: " + ID + ", Name: " + name);

        // Check if the student is not enrolled in any courses
        if (enrolledCourses.isEmpty()) {
            System.out.println("Not enrolled in any courses (yet).");
            return;
        }

        System.out.println("Enrolled Courses:");
        // Loop through the student's enrolled courses and print them
        for (EnrolledCourse course : enrolledCourses) {
            System.out.println("Enrolled in: " + course.getName() + ", Grade: " + course.getGrade());
        }
    }
}
