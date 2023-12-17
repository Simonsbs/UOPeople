// Student.java

/**
 * The Student class represents a student with their personal and academic
 * details.
 */
public class Student {
    // Private instance variables to store student information
    private String name;
    private String ID;
    private int age;
    private double grade;

    /**
     * Constructor to initialize a new Student object with given details.
     * 
     * @param name  - The name of the student.
     * @param ID    - The unique identifier for the student.
     * @param age   - The age of the student.
     * @param grade - The grade of the student.
     */
    public Student(String name, String ID, int age, double grade) {
        this.name = name;
        this.ID = ID;
        this.age = age;
        this.grade = grade;
    }

    /**
     * Getter for the student's name.
     * 
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the student's name.
     * 
     * @param name - The new name of the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the student's ID.
     * 
     * @return The ID of the student.
     */
    public String getID() {
        return ID;
    }

    /**
     * Setter for the student's ID.
     * 
     * @param ID - The new ID of the student.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Getter for the student's age.
     * 
     * @return The age of the student.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter for the student's age.
     * 
     * @param age - The new age of the student.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter for the student's grade.
     * 
     * @return The grade of the student.
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Setter for the student's grade.
     * 
     * @param grade - The new grade of the student.
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }
}
