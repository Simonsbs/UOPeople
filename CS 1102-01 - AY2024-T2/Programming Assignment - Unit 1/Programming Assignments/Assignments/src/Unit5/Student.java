package Unit5;

import java.util.ArrayList;

/**
 * The Student class represents a student in a university.
 * It stores the student's name, ID, and the courses they are enrolled in,
 * along with the grades for each course.
 */
public class Student {
    private String name;
    private String ID;
    private ArrayList<EnrolledCourse> enrolledCourses;

    /**
     * Constructor for the Student class.
     *
     * @param name the name of the student.
     * @param ID   the unique ID of the student.
     */
    public Student(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.enrolledCourses = new ArrayList<>();
    }

    /**
     * Enrolls the student in a course.
     *
     * @param course the course to enroll in.
     */
    public void enrollInCourse(Course course) {
        enrolledCourses.add(new EnrolledCourse(course));
    }

    /**
     * Assigns a grade to the student for a specific course.
     *
     * @param course the course to assign the grade to.
     * @param grade  the grade to assign.
     */
    public void assignGrade(Course course, String grade) {
        // int courseIndex = enrolledCourses.indexOf(course);
        // if (courseIndex != -1) {
        // grades.set(courseIndex, grade);
        // }
    }

    /**
     * Gets the student's name.
     *
     * @return the name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the student's name.
     *
     * @param name the name to set for the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the student's ID.
     *
     * @return the ID of the student.
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the student's ID.
     *
     * @param ID the ID to set for the student.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Gets a list of courses the student is enrolled in.
     *
     * @return the list of enrolled courses.
     */
    public ArrayList<EnrolledCourse> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses); // Return a copy to prevent external modification
    }

    /**
     * Gets the grades of the student for their courses.
     *
     * @return the list of grades for each enrolled course.
     */
    public ArrayList<String> getGrades() {
        return new ArrayList<>(grades); // Return a copy to prevent external modification
    }
}
