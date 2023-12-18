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
     * Adds a new EnrolledCourse object to the enrolledCourses list.
     *
     * @param course the course to enroll in
     */
    public void enrollInCourse(Course course) {
        enrolledCourses.add(new EnrolledCourse(course));
    }

    /**
     * Assigns a grade to the student for a specific course.
     * Updates the grade in the corresponding EnrolledCourse object.
     *
     * @param courseCode the course code of the course to assign the grade to
     * @param grade      the grade to assign
     */
    public void setCourseGrade(Course course, float grade) {
        for (EnrolledCourse enrolledCourse : enrolledCourses) {
            if (enrolledCourse.getCourseCode().equals(course.getCourseCode())) {
                enrolledCourse.setGrade(grade);
                return;
            }
        }
        System.out.println("Course not found or student not enrolled in the course.");
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
     * @param name the name to set for the student
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
     * @param ID the ID to set for the student
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Gets a list of courses the student is enrolled in.
     * Returns a copy of the enrolledCourses list to prevent external modification.
     *
     * @return the list of enrolled courses
     */
    public ArrayList<EnrolledCourse> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses);
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
     * Prints the student's info to the console.
     */
    public void print() {
        System.out.println("ID: " + ID + ", Name: " + name);
    }

    /**
     * Converts a float grade to a string grade.
     * 
     * @param grade The grade to convert.
     * @return The string representation of the grade.
     */
    public final static String getGradeAsString(float grade) {
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
     * Prints the student's info and final grade to the console.
     */
    public void printFinalGrade() {
        float owl = this.getGPA();
        print();
        System.out.println("OWL: " + owl + ", Grade: " + getGradeAsString(owl));
    }
}
