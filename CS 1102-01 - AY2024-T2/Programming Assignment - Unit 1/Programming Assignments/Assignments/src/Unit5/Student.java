// Course.java
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
        if (course.canEnroll()) {
            EnrolledCourse enrolledCourse = new EnrolledCourse(course);
            enrolledCourses.add(enrolledCourse);
            course.incrementEnrolledStudents();
            return "Student enrolled in " + course.getName() + " successfully.";
        }
        return "Cannot enroll in " + course.getName() + ", course is full.";
    }

    /**
     * Sets a grade to the student for a specific course.
     *
     * @param course the course to set the grade to
     * @param grade  the grade to set
     */
    public void setCourseGrade(Course course, float grade) {
        for (EnrolledCourse enrolledCourse : enrolledCourses) {
            if (enrolledCourse.getCourseCode().equals(course.getCourseCode())) {
                enrolledCourse.setGrade(grade);
                return;
            }
        }
        System.out.println("Student not enrolled in " + course.getName() + ".");
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
        if (enrolledCourses.isEmpty()) {
            return 0.0f;
        }
        float totalGrade = 0.0f;
        for (EnrolledCourse course : enrolledCourses) {
            totalGrade += course.getGrade();
        }
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
        for (EnrolledCourse course : enrolledCourses) {
            System.out.println("Enrolled in: " + course.getName() + ", Grade: " + course.getGrade());
        }
    }
}
