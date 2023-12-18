package Unit5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * The CourseManagement class is responsible for managing courses and students
 * in a Hogwarts-themed course management system. It provides functionalities to
 * add courses, add students, enroll students in courses, assign grades,
 * calculate grades,
 * and list all students and courses. It uses a command-line interface for user
 * interaction.
 */
public class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * The main method that drives the program.
     * It initializes the system and processes user input to perform various
     * operations.
     */
    public static void main(String[] args) {
        initializeSystem();

        hr();
        System.out.println("| Welcome to the Hogwarts Course Management System. |");
        System.out.println("| Please select an option below.                    |");

        boolean exit = false;
        while (!exit) {
            hr();
            System.out.println("System Menu:");
            System.out.println("1. Add a new magic course");
            System.out.println("2. Add a new Hogwarts student");
            System.out.println("3. Enroll a student in a magic course");
            System.out.println("4. Assign a grade for magical studies");
            System.out.println("5. Calculate OWL's for a student");
            System.out.println("6. List all students");
            System.out.println("7. List all courses");
            System.out.println("E. Exit");
            System.out.print("Enter your choice:");

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
                    calculateFinalGrade();
                    break;
                case "6":
                    listAllStudents();
                    break;
                case "7":
                    listAllCourses();
                    break;
                case "E":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. try again muggle!");
            }
        }

        System.out.println("Thank you for using the Hogwarts Course Management System.");
        System.out.println("Have a magical day!");
    }

    /**
     * Prints a horizontal rule to the console for better readability.
     */
    private static void hr() {
        System.out.println("-----------------------------------------------------");
    }

    /**
     * Initializes the system with predefined courses and students.
     */
    private static void initializeSystem() {
        // Initialize courses
        courses.add(new Course("POT101", "Potions", 30));
        courses.add(new Course("DADA101", "Defense Against the Dark Arts", 30));
        courses.add(new Course("CHRM101", "Charms", 30));
        courses.add(new Course("HERB101", "Herbology", 30));

        // Initialize students
        students.add(new Student("Harry Potter", "001"));
        students.add(new Student("Hermione Granger", "002"));
        students.add(new Student("Ron Weasley", "003"));
        students.add(new Student("Draco Malfoy", "004"));

        // Enroll each student in each course and assign random grades
        Random random = new Random();
        for (Student student : students) {
            for (Course course : courses) {
                student.enrollInCourse(course);
                // Assuming grades are from 0.0 to 100.0
                float randomGrade = 50.0f + random.nextFloat() * 50.0f; // Grades between 50.0 and 100.0
                student.setCourseGrade(course, randomGrade);
            }
        }
    }

    /**
     * Adds a new student to the system.
     */
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student ID: ");
        String id = scanner.next();

        Student student = new Student(name, id);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    /**
     * Adds a new course to the system.
     */
    private static void addCourse() {
        System.out.print("Enter course code: ");
        String code = scanner.next();
        System.out.print("Enter course name: ");
        String name = scanner.next();
        System.out.print("Enter max capacity: ");
        int capacity = scanner.nextInt();

        Course course = new Course(code, name, capacity);
        courses.add(course);
        System.out.println("Course added successfully.");
    }

    /**
     * Enrolls a student in a specified course.
     */
    private static void enrollStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.next();
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course code to enroll: ");
        String code = scanner.next();
        Course course = findCourseByCode(code);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        // Check if the course can accept more students
        if (!course.canEnroll()) {
            System.out.println("Course is full, cannot enroll any more students.");
            return;
        }

        student.enrollInCourse(course);
        course.incrementEnrolledStudents(); // Update the number of enrolled students in the course
        System.out.println("Student enrolled successfully.");
    }

    /**
     * Set a grade for a student for a specific course.
     */
    private static void setGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("Enter grade (as a float): ");
        float grade = scanner.nextFloat();

        // Find the enrolled course and assign the grade
        for (EnrolledCourse enrolledCourse : student.getEnrolledCourses()) {
            if (enrolledCourse.getCourseCode().equals(courseCode)) {
                enrolledCourse.setGrade(grade);
                System.out.println("Grade assigned successfully.");
                return;
            }
        }

        System.out.println("Student is not enrolled in the specified course.");
    }

    /**
     * Calculates and displays the final grade for a student.
     */
    private static void calculateFinalGrade() {
        System.out.print("Enter student ID to calculate OWL's: ");
        String studentId = scanner.next();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.printFinalGrade();
    }

    /**
     * Finds a student by their ID.
     * 
     * @param id The ID of the student.
     * @return The Student object if found, null otherwise.
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
     * Finds a course by its code.
     * 
     * @param code The code of the course.
     * @return The Course object if found, null otherwise.
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
     * Lists all students registered in the system.
     */
    private static void listAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        System.out.println("List of all Hogwarts students:");
        for (Student student : students) {
            student.print();
        }
    }

    /**
     * Lists all courses available in the system.
     */
    private static void listAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("List of all magic courses:");
        for (Course course : courses) {
            course.print();
        }
    }
}
