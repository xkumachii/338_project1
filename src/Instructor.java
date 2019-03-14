/**
 * Name: Marc Alejandro
 * Date: 03/13/19
 * Explanation: Instructor.java details an instructor under School.java.
 */

import java.util.HashMap;

public class Instructor {

    //fields
    private int number;
    private String name;
    private String email;
    private String phoneNumber;

    //object dependent fields
    private HashMap<Integer, Course> currentCourses;

    //getters and setters

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public HashMap<Integer, Course> getCurrentCourses() {
        return currentCourses;
    }

    public void setCurrentCourses(HashMap<Integer, Course> currentCourses) {
        this.currentCourses = currentCourses;
    }

    //constructor

    public Instructor(int number, String name, String email, String phoneNumber) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.currentCourses = new HashMap<>();
    }

    // toString()


    @Override
    public String toString() {
        String num = "Instructor number: " + this.number;
        String name = "\nName: " + this.name;
        String currentlyTeaching = "\nCurrently Teaching: ";
        for (Integer i : this.currentCourses.keySet()) {
            currentlyTeaching += "\n" + i + ": " + this.currentCourses.get(i).getNumStudents() + " enrolled";
        }

        return num + name + currentlyTeaching;
    }
}
