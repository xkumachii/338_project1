/**
 * Name: Marc Alejandro
 * Date: 03/13/19
 * Explanation: Student.java details a student under School.java.
 */

import java.util.HashMap;

public class Student {

    //fields

    private int ID;
    private String name;
    private HashMap<Integer, Course> currentCourses;

    // getters and setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Course> getCurrentCourses() {
        return currentCourses;
    }

    public void setCurrentCourses(HashMap<Integer, Course> currentCourses) {
        this.currentCourses = currentCourses;
    }

    // constructor

    public Student(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.currentCourses = new HashMap<>();
    }

    // toString()


    @Override
    public String toString() {
        String id = "Student Number: " + this.ID;
        String name = "\nName: "+ this.name;
        String currentlyEnrolled = "\nCourses Enrolled: ";

        double average = 0;
        for (Integer i : this.currentCourses.keySet()) {
            currentlyEnrolled += "\n" + i + ": " + this.currentCourses.get(i).getScores().get(this.ID);
            average += this.currentCourses.get(i).getScores().get(this.ID);
        }

        if (currentCourses.size() > 0) {
            average /= currentCourses.size();
        }

        String avg = "\nCourse average: " + average;

        return id + name + currentlyEnrolled + avg;

    }
}
