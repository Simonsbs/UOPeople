package Unit5;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeSystem();
        displayWelcomeMessage();
        processUserCommands();
    }

    private static void displayWelcomeMessage() {
        hr();
        System.out.println("| Welcome to the Hogwarts Course Management System. |");
        System.out.println("| Please select an option below.                    |");
        System.out.println("|    - Remember, bureaucracy is the real magic -   |");
    }

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

    private static void displayMenu() {
        hr();
        System.out.println("Magical System Menu:");
        System.out.println("1. Add a new magic course");
        System.out.println("2. Add a new Hogwarts student");
        System.out.println("3. Enroll a student in a magic course");
        System.out.println("4. Set a grade for magical studies");
        System.out.println("5. Calculate OWLs for a student");
        System.out.println("6. List all students");
        System.out.println("7. List all courses");
        System.out.println("E. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void initializeSystem() {
        courses.add(new Course("POT101", "Potions", 5));
        courses.add(new Course("DADA101", "Defense Against the Dark Arts", 5));
        courses.add(new Course("CHRM101", "Charms", 5));
        courses.add(new Course("HERB101", "Herbology", 5));

        students.add(new Student("Harry Potter", "001"));
        students.add(new Student("Hermione Granger", "002"));
        students.add(new Student("Ron Weasley", "003"));
        students.add(new Student("Draco Malfoy", "004"));
    }

    private static void addCourse() {
        System.out.print("Enter course code: ");
        String code = scanner.next();
        System.out.print("Enter course name: ");
        String name = scanner.next();
        int capacity;
        while (true) {
            System.out.print("Enter max capacity: ");
            if (scanner.hasNextInt()) {
                capacity = scanner.nextInt();
                if (capacity > 0)
                    break;
                else
                    System.out.println("Capacity must be a positive integer.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
        Course course = new Course(code, name, capacity);
        courses.add(course);
        System.out.println("Course added successfully.");
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        String id;
        while (true) {
            System.out.print("Enter student ID: ");
            id = scanner.next();
            if (!id.trim().isEmpty() && findStudentById(id) == null)
                break;
            else
                System.out.println("Invalid or duplicate ID. Please enter a unique ID.");
        }
        Student student = new Student(name, id);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    private static void enrollStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();

        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            if (course.canEnroll()) {
                student.enrollInCourse(course);
                course.incrementEnrolledStudents();
                System.out.println("Student enrolled successfully.");
            } else {
                System.out.println("Course is full, cannot enroll any more students.");
            }
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

    private static void setGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        float grade;
        while (true) {
            System.out.print("Enter grade (0.0-100.0): ");
            if (scanner.hasNextFloat()) {
                grade = scanner.nextFloat();
                if (grade >= 0.0f && grade <= 100.0f)
                    break;
                else
                    System.out.println("Grade must be between 0.0 and 100.0.");
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear invalid input
            }
        }

        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            student.setCourseGrade(course, grade);
            System.out.println("Grade set successfully.");
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

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

    private static void listAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (Student student : students) {
                student.print();
            }
        }
    }

    private static void listAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course course : courses) {
                course.print();
            }
        }
    }

    private static Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getID().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourseByCode(String code) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    private static void hr() {
        System.out.println("-----------------------------------------------------");
    }
}
