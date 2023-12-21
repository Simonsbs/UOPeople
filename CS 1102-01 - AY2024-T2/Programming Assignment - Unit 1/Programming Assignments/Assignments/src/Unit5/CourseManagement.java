// CourseManagement.java
package Unit5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The CourseManagement class is the main class of the Hogwarts Course
 * Management System.
 * It provides a menu for the user to interact with the system.
 */
public class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * The main method of the CourseManagement class.
     * Initializes the system, displays a welcome message, and processes user
     * commands.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        initializeSystem();
        displayWelcomeMessage();
        processUserCommands();
    }

    /**
     * Displays a welcome message to the user.
     */
    private static void displayWelcomeMessage() {
        hr();
        System.out.println("| Welcome to the Hogwarts Course Management System. |");
        System.out.println("| Please select an option below.                    |");
        System.out.println("|    - Remember, bureaucracy is the real magic -   |");
    }

    /**
     * Displays the menu and processes user selection.
     */
    private static void processUserCommands() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            String choice = scanner.next();
            hr();
            switch (choice.toUpperCase()) {
                case "1":
                    addCourse();
                    break;
                case "2":
                    addStudent();
                    break;
                case "3":
                    enrollStudent();
                    break;
                case "4":
                    setGrade();
                    break;
                case "5":
                    calculateFinalGrades();
                    break;
                case "6":
                    listAllStudents();
                    break;
                case "7":
                    listAllCourses();
                    break;
                case "8":
                    editStudentInfo();
                    break;
                case "9":
                    editCourseInfo();
                    break;
                case "E":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again, muggle!");
            }
        }
        System.out.println("Thank you for using the Hogwarts Course Management System.");
        System.out.println("Have a magical day!");
    }

    /**
     * Displays the menu.
     */
    private static void displayMenu() {
        hr();
        System.out.println("Magical System Menu:");
        System.out.println("1. Add a new magic course");
        System.out.println("2. Add a new Hogwarts student");
        System.out.println("3. Enroll a student in a magic course");
        System.out.println("4. Set a grade for magical studies");
        System.out.println("5. View OWLs for a student");
        System.out.println("6. List all students");
        System.out.println("7. List all courses");
        System.out.println("8. Edit a student's information");
        System.out.println("9. Edit a course's information");
        System.out.println("E. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void editStudentInfo() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        Student student = findStudentById(studentId);
        if (student != null) {
            System.out.print("Enter new student name: ");
            String name = scanner.next();
            System.out.print("Enter new student ID: ");
            String newId = scanner.next();

            student.editStudentInfo(name, newId);
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void editCourseInfo() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        Course course = findCourseByCode(courseCode);
        if (course != null) {
            System.out.print("Enter new course name: ");
            String name = scanner.next();
            int capacity = Utils.readPositiveInt(scanner, "Enter new max capacity: ");
            course.editCourseInfo(name, capacity);
            System.out.println("Course information updated successfully.");
        } else {
            System.out.println("Invalid course code.");
        }
    }

    /**
     * Initializes the system with some courses and students.
     */
    private static void initializeSystem() {
        courses.add(new Course("POT101", "Potions", 5));
        courses.add(new Course("DADA101", "Defense Against the Dark Arts", 5));
        courses.add(new Course("CHRM101", "Charms", 5));
        courses.add(new Course("HERB101", "Herbology", 5));

        students.add(new Student("Harry Potter", "001"));
        students.add(new Student("Hermione Granger", "002"));
        students.add(new Student("Ron Weasley", "003"));
        students.add(new Student("Draco Malfoy", "004"));

        for (Course course : courses) {
            for (Student student : students) {
                student.enrollInCourse(course);
            }
        }
    }

    /**
     * Adds a new course to the system.
     */
    private static void addCourse() {
        Course newCourse = Course.addNewCourse(scanner);
        courses.add(newCourse);
        System.out.println("Course added successfully.");
    }

    private static void addStudent() {
        Student newStudent = Student.addNewStudent(scanner, students);
        students.add(newStudent);
        System.out.println("Student added successfully.");
    }

    /**
     * Enrolls a student in a course.
     */
    private static void enrollStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();

        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            String message = student.enrollInCourse(course);
            System.out.println(message);
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

    /**
     * Sets a grade for a student in a course.
     */
    private static void setGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();

        float grade = Utils.readFloatInRange(scanner, "Enter grade (0.0-100.0): ", 0.0f, 100.0f);

        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            student.setCourseGrade(course, grade);
            System.out.println("Grade set successfully.");
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

    /**
     * Calculates the final grade for a student.
     */
    private static void calculateFinalGrades() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        Student student = findStudentById(studentId);
        if (student != null) {
            student.printFinalGrade();
        } else {
            System.out.println("Student not found.");
        }
    }

    /**
     * Lists all students in the system.
     */
    private static void listAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (Student student : students) {
                student.print();
            }
        }
    }

    /**
     * Lists all courses in the system.
     */
    private static void listAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course course : courses) {
                course.print();
            }
        }
    }

    /**
     * Finds a student by ID.
     *
     * @param id the ID of the student to find
     * @return the student with the given ID, or null if not found
     */
    private static Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getID().equals(id)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Finds a course by code.
     *
     * @param code the code of the course to find
     * @return the course with the given code, or null if not found
     */
    private static Course findCourseByCode(String code) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Prints a horizontal line.
     */
    private static void hr() {
        System.out.println("-----------------------------------------------------");
    }
}
