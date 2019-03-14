/**
 * Name: Marc Alejandro
 * Date: 03/13/19
 * Explanation: School.java is a class detailing a kind of school, and its constituents and
 *              actions thereof.
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;

public class School {

    // fields

    private String name;

    private HashMap<Integer, Student> students;
    private HashMap<Integer, Course> courses;
    private HashMap<Integer, Instructor> instructors;

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Student> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Integer, Student> students) {
        this.students = students;
    }

    public HashMap<Integer, Course> getCourses() {
        return courses;
    }

    public void setCourses(HashMap<Integer, Course> courses) {
        this.courses = courses;
    }

    public HashMap<Integer, Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(HashMap<Integer, Instructor> instructors) {
        this.instructors = instructors;
    }

    public Course getCourse(int courseNum) {
        return courses.get(courseNum);
    }

    public Student getStudent(int ID) {
        return students.get(ID);
    }

    public Instructor getInstructor(int courseNum) {
        return courses.get(courseNum).getCurrentInstructor();
    }

    // constructor

    public School(String name) {
        this.name = name;
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
        this.instructors = new HashMap<>();
    }

    // helper functions for readData, addInstructor, addCourse, and register

    //adding students

    private boolean studentNumberAlreadyExists(String[] input) {
        int id = Integer.parseInt(input[0]);
        if (students.containsKey(id)) {
            System.out.println("Student info reading failed – Student ID " + id + " already used.");
            return true;
        }
        return false;
    }

    private void inputStudents(String[] input) {
        if (!studentNumberAlreadyExists(input)) {
            int id = Integer.parseInt(input[0]);
            students.put(id, new Student(id, input[1]));
        }
    }

    //adding courses

    private boolean courseNumberAlreadyExists(String[] input) {
        int num = Integer.parseInt(input[0]);
        if (courses.containsKey(num)) {
            System.out.println("Course addition failed – Course number " + num + " already used.");
            return true;
            }
        return false;
    }

    private void inputCourses(String[] input) {
        if (!(courseNumberAlreadyExists(input))) {
            int courseNum = Integer.parseInt(input[0]);
            int cap = Integer.parseInt(input[2]);
            courses.put(courseNum, new Course(courseNum, input[1], cap, input[3]));
        }
    }

    //adding teachers

    private boolean teacherNumberAlreadyExists(String[] input) {
        int num = Integer.parseInt(input[0]);
        if (instructors.containsKey(num)) {
            System.out.println("Instructor info reading failed – Employee number " + num + " already used.");
            return true;
        }
        return false;
    }

    private void inputTeachers(String[] input) {
        if (!(teacherNumberAlreadyExists(input))) {
            int num = Integer.parseInt(input[0]);
            instructors.put(num, new Instructor(num, input[1], input[2], input[3]));
        }
    }

    // public functions

    public void readData(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            for (int i = 0; i < 3; i++) {
                line = reader.readLine();

                int end = Integer.parseInt(line);
                for (int j = 0; j < end; j++) {
                    line = reader.readLine();
                    String[] dataInput = new String[line.split(",").length];
                    dataInput = line.split(",");
                    switch(i) {
                        case 0:
                            inputTeachers(dataInput);
                            break;
                        case 1:
                            inputCourses(dataInput);
                            break;
                        case 2:
                            inputStudents(dataInput);
                            break;
                    }
                }
            }
            System.out.println("Done.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("I/O Error.");
        }
    }

    // schoolInfo()

    public void schoolInfo() {
        System.out.println("School Name: " + this.name);
        System.out.println("Instructor Information: ");
        for (Integer i : instructors.keySet()) {
            System.out.println(instructors.get(i).getName());
        }
        System.out.println("Course Information: ");
        for (Integer i : courses.keySet()) {
            System.out.println(courses.get(i).getCourseTitle());
        }
        System.out.println("Student Information: ");
        for (Integer i : students.keySet()) {
            System.out.println(students.get(i).getName());
        }
    }

    //searchByEmail()

    public boolean searchByEmail(String email) {
        System.out.println("Search Key: " + email);
        if (instructors.containsKey(email)) {
            System.out.println("Employee Number: " + instructors.get(email).getNumber());
            System.out.println("Name: " + instructors.get(email).getName());
            System.out.println("Phone: " + instructors.get(email).getPhoneNumber());
            return true;
        }
        System.out.println("No employee with email: " + email);
        return false;
    }

    // assignInstructor()

    public boolean assignInstructor(int courseNum, int employeeNum) {
        // assume that a professor is able to teach multiple classes,
        // but a class can only have one professor

        if (courses.containsKey(courseNum) && instructors.containsKey(employeeNum)) {
            courses.get(courseNum).setCurrentInstructor(instructors.get(employeeNum));
            instructors.get(employeeNum).getCurrentCourses().put(courseNum, courses.get(courseNum));
            courses.get(courseNum).setInstructor(true);
            return true;
        } else if (!courses.containsKey(courseNum)) {
            System.out.println("Course " + courseNum + " does not exist.");
            return false;
        } else if (!instructors.containsKey(employeeNum)) {
            System.out.println("Instructor " + employeeNum + " does not exist.");
            return false;
        } else if (courses.get(courseNum).isInstructor()) {
            System.out.print(courses.get(courseNum).getCurrentInstructor().getName());
            System.out.println(" Is currently teaching Course " + courseNum);
            return false;
        }
        return false;
    }

    // register()

    public boolean register(int courseNum, int ID) {
        if (courses.get(courseNum).getNumStudents() == courses.get(courseNum).getCourseCapacity()) {
            System.out.println("Registration failed – Class is full.");
            return false;
        }

        if (courses.containsKey(courseNum) && students.containsKey(ID)) {
            courses.get(courseNum).getStudents().put(ID, students.get(ID));
            students.get(ID).getCurrentCourses().put(courseNum, courses.get(courseNum));
            courses.get(courseNum).setNumStudents(courses.get(courseNum).getNumStudents() + 1);
            return true;
        } else if (!courses.containsKey(courseNum)) {
            System.out.println("Course " + courseNum + " does not exist.");
            return false;
        } else if (!students.containsKey(ID)) {
            System.out.println("Student " + ID + " does not exist.");
            return false;
        }

        return false;
    }

    //unRegister()

    public boolean unRegister(int courseNum, int ID) {
        if (courses.containsKey(courseNum) && students.containsKey(ID)) {
            courses.get(courseNum).getStudents().remove(ID);
            students.get(ID).getCurrentCourses().remove(courseNum);
            courses.get(courseNum).setNumStudents(courses.get(courseNum).getNumStudents() - 1);
            courses.get(courseNum).getScores().remove(ID);
            return true;
        } else if (!courses.containsKey(courseNum)) {
            System.out.println("Course " + courseNum + " does not exist.");
            return false;
        } else if (!students.containsKey(ID)) {
            System.out.println("Student " + ID + " does not exist.");
            return false;
        }
        return false;
    }

    // graduateStudent()

    public boolean graduateStudent(int ID) {
        if (students.containsKey(ID)) {
            ArrayList<Integer> courseNums = new ArrayList<>(students.get(ID).getCurrentCourses().keySet());

            for (int i : courseNums) {
                unRegister(i, ID);
            }

            students.remove(ID);
            return true;
        } else {
            System.out.println("Student " + ID + " does not exist.");
            return false;
        }
    }

    // putScore()

    public boolean putScore(int courseNum, int ID, double score) {
        if (courses.containsKey(courseNum) &&
            students.containsKey(ID) &&
            students.get(ID).getCurrentCourses().containsKey(courseNum)) {
            courses.get(courseNum).getScores().put(ID, score);
            return true;
        } else if (!courses.containsKey(courseNum)) {
            System.out.println("Course " + courseNum + " does not exist.");
            return false;
        } else if (!students.containsKey(ID)) {
            System.out.println("Student " + ID + " does not exist.");
            return false;
        } else if (!students.get(ID).getCurrentCourses().containsKey(courseNum)) {
            String line = "Student " + ID + "(" + students.get(ID).getName()
                                    + ") is not enrolled in " + courseNum;
            System.out.println(line);
            return false;
        }
        return false;
    }

    // courseInfo()

    public void courseInfo(int courseNum) {
        if (courses.containsKey(courseNum)) {
            System.out.println("Course number: " + courseNum);
            System.out.println("Instructor: " + courses.get(courseNum).getCurrentInstructor().getName());
            System.out.println("Course Title: " + courses.get(courseNum).getCourseTitle());
            System.out.println("Room: " + courses.get(courseNum).getCourseLocation());
            System.out.println("Total Enrolled: " + courses.get(courseNum).getNumStudents());

            double average = 0;

            for (Integer i : courses.get(courseNum).getScores().keySet()) {
                average += courses.get(courseNum).getScores().get(i);
            }

            if (courses.get(courseNum).getNumStudents() != 0) {
                average /= courses.get(courseNum).getNumStudents();
            }

            System.out.println("Course Average: " + average);
        } else {
            System.out.println("Course number: " + courseNum + " does not exist.");
        }
    }

    public void courseInfo() {
        System.out.println("Number of Courses: " + courses.size());
        for (Integer i : courses.keySet()) {
            System.out.println(i + ": " + courses.get(i).getNumStudents() + " enrolled");
        }
    }

    public boolean deleteCourse(int courseNum) {
        if (courses.containsKey(courseNum)) {
            if (courses.get(courseNum).getNumStudents() == 0) {
                if (courses.get(courseNum).getCurrentInstructor() != null) {
                    int employeeNum = courses.get(courseNum).getCurrentInstructor().getNumber();
                    instructors.get(employeeNum).getCurrentCourses().remove(courseNum);
                }
                courses.remove(courseNum);
                return true;
            } else {
                System.out.println("Course deletion failed – Enrolled student(s) in the class");
                return false;
            }
        } else {
            System.out.println("Course number: " + courseNum + " does not exist.");
            return false;
        }
    }

    public void addInstructor(int courseNum, String name, String email, String phoneNumber) {
        String num = Integer.toString(courseNum);
        String[] teacher = {num, name, email, phoneNumber};
        inputTeachers(teacher);
    }

    public void addCourse(int courseNum, String title, int capacity, String location) {
        String num = Integer.toString(courseNum);
        String cap = Integer.toString(capacity);
        String[] course = {num, title, cap, location};
        inputCourses(course);
    }

    public void addStudent(int ID, String name) {
        String id = Integer.toString(ID);
        String[] student = {id, name};
        inputStudents(student);
    }

}