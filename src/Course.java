/**
 * Name: Marc Alejandro
 * Date: 03/13/19
 * Explanation: Course.java details a course under School.java.
 */


import java.util.HashMap;

public class Course {

    //fields

    private int courseNum;
    private String courseTitle;
    private int courseCapacity;
    private String courseLocation;

    // object-dependent fields;

    private int numStudents;
    private Instructor currentInstructor;
    private HashMap<Integer, Student> students;
    private HashMap<Integer, Double> scores;
    private boolean isInstructor;

    //getters and setters

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public Instructor getCurrentInstructor() {
        return currentInstructor;
    }

    public void setCurrentInstructor(Instructor currentInstructor) {
        this.currentInstructor = currentInstructor;
    }

    public HashMap<Integer, Student> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Integer, Student> students) {
        this.students = students;
    }

    public HashMap<Integer, Double> getScores() {
        return scores;
    }

    public void setScores(HashMap<Integer, Double> scores) {
        this.scores = scores;
    }

    public boolean isInstructor() {
        return isInstructor;
    }

    public void setInstructor(boolean instructor) {
        isInstructor = instructor;
    }

    //constructors

    public Course(int courseNum, String courseTitle, int courseCapacity, String courseLocation) {
        this.courseNum = courseNum;
        this.courseTitle = courseTitle;
        this.courseCapacity = courseCapacity;
        this.courseLocation = courseLocation;
        this.numStudents = 0;
        this.students = new HashMap<>();
        this.scores = new HashMap<>();
        this.isInstructor = false;
    }

    // public functions
    void updateLocation(String location) {
        this.setCourseLocation(location);
    }
}
