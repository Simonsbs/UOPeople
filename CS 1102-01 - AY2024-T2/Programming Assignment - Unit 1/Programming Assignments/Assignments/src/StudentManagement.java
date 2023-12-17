// StudentManagement.java

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The StudentManagement class manages a list of students and provides
 * controls to add, update, view, and manage student info.
 */
public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Adds a new student to the list.
     * 
     * @param student - The student to be added.
     */
    public static void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    /**
     * Updates the information of an existing student.
     * 
     * @param ID             - The ID of the student to be updated.
     * @param updatedStudent - The student object with updated information.
     */
    public static void updateStudent(String ID, Student updatedStudent) {
        for (Student student : students) {
            if (student.getID().equals(ID)) {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                student.setGrade(updatedStudent.getGrade());
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    /**
     * Displays the details of a specific student.
     * 
     * @param ID - The ID of the student whose details are to be viewed.
     */
    public static void viewStudent(String ID) {
        for (Student student : students) {
            if (student.getID().equals(ID)) {
                System.out.println("Name: " + student.getName());
                System.out.println("ID: " + student.getID());
                System.out.println("Age: " + student.getAge());
                System.out.println("Grade: " + student.getGrade());
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    /**
     * Gets integer input from the user with validation.
     * 
     * @return A valid integer input.
     */
    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Creates a Student object based on user input.
     * 
     * @return A new Student object.
     */
    private static Student createStudentFromInput() {
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter ID: ");
        String ID = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = getIntInput();

        System.out.print("Enter Grade: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        double grade = scanner.nextDouble();

        return new Student(name, ID, age, grade);
    }

    /**
     * Handles the process of updating student information.
     */
    private static void updateStudentInfo() {
        System.out.print("Enter Student ID to Update: ");
        String updateID = scanner.nextLine();

        // Check if the student with the given ID exists
        boolean studentExists = false;
        for (Student student : students) {
            if (student.getID().equals(updateID)) {
                studentExists = true;
                break;
            }
        }

        // If student exists, proceed with update. Otherwise,
        // notify user and return to menu
        if (studentExists) {
            Student updatedStudent = createStudentFromInput();
            updateStudent(updateID, updatedStudent);
        } else {
            System.out.println("Student ID not found.");
        }
    }

    /**
     * The main method to run the application. It displays a menu for managing
     * students.
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add New Student\n2. Update Student Information\n3. View Student Details\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addStudent(createStudentFromInput());
                    break;
                case 2:
                    updateStudentInfo();
                    break;
                case 3:
                    System.out.print("Enter Student ID to View: ");
                    scanner.nextLine();
                    viewStudent(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
