package Unit5;

import java.util.Scanner;
import java.util.ArrayList;

public class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Course Management System");
            System.out.println("1. Add a new course");
            System.out.println("2. Enroll a student");
            System.out.println("3. Assign grade");
            System.out.println("4. Calculate overall grades");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    enrollStudent();
                    break;
                case 3:
                    assignGrade();
                    break;
                case 4:
                    calculateOverallGrades();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
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
        System.out.print("Enter student ID to calculate GPA: ");
        String studentId = scanner.next();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        float gpa = student.getGPA();
        System.out.println("Student's GPA: " + gpa);
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
}
