import java.util.ArrayList;
import java.util.HashMap;

public class Course {

    //fields

    private int courseNum;
    private String courseTitle;
    private int courseCapacity;
    private String courseLocation;

    // object-dependent fields;

    private int numStudents;
    private String currentInstructor;
    private ArrayList<Student> students;
    private HashMap<Student, Integer> scores;

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

    //constructors

    public Course(int courseNum, String courseTitle, int courseCapacity, String courseLocation) {
        this.courseNum = courseNum;
        this.courseTitle = courseTitle;
        this.courseCapacity = courseCapacity;
        this.courseLocation = courseLocation;
        this.numStudents = 0;
        this.students = new ArrayList<>();
        this.scores = new HashMap<>();
    }

    // public functions
    void updateLocation(String location) {
        this.setCourseLocation(location);
    }
}
