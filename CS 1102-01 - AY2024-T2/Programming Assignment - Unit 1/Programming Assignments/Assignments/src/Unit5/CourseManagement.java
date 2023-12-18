package Unit5;

import java.util.Scanner;
import java.util.ArrayList;

public class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

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
            System.out.println("5. Calculate OWL's and NEWT's");
            System.out.println("6. List all students");
            System.out.println("7. List all courses");
            System.out.println("8. Exit");
            System.out.print("Enter your choice:");

            int choice = scanner.nextInt();
            hr();
            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    enrollStudent();
                    break;
                case 4:
                    assignGrade();
                    break;
                case 5:
                    calculateOverallGrades();
                    break;
                case 6:
                    listAllStudents();
                    break;
                case 7:
                    listAllCourses();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. try again muggle!");

            }
        }

        System.out.println("Thank you for using the Hogwarts Course Management System.");
        System.out.println("Have a magical day!");
    }

    private static void hr() {
        System.out.println("-----------------------------------------------------");
    }

    private static void initializeSystem() {
        // Add predefined courses
        courses.add(new Course("POT101", "Potions", 5));
        courses.add(new Course("DADA101", "Defense Against the Dark Arts", 5));
        courses.add(new Course("CHRM101", "Charms", 5));
        courses.add(new Course("HERB101", "Herbology", 5));

        // Add predefined students
        students.add(new Student("Harry Potter", "001"));
        students.add(new Student("Hermione Granger", "002"));
        students.add(new Student("Ron Weasley", "003"));
        students.add(new Student("Draco Malfoy", "004"));
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student ID: ");
        String id = scanner.next();

        Student student = new Student(name, id);
        students.add(student);
        System.out.println("Student added successfully.");
    }

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

    private static void assignGrade() {
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

    private static void calculateOverallGrades() {
        System.out.print("Enter student ID to calculate OWL's: ");
        String studentId = scanner.next();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        float owl = student.getGPA();
        System.out.println("Student's OWL's: " + owl);
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

    private static void listAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        System.out.println("List of all Hogwarts students:");
        for (Student student : students) {
            System.out.println("ID: " + student.getID() + ", Name: " + student.getName());
        }
    }

    private static void listAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("List of all magic courses:");
        for (Course course : courses) {
            System.out.println("Code: " + course.getCourseCode() + ", Name: " + course.getName() + ", Capacity: "
                    + course.getMaxCapacity());
        }
    }
}
