import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class School {

    // fields

    private int numInstructors;
    private int numCourses;
    private int numStudents;
    private String name;


    // class-dependent fields

    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Instructor> instructors;

    // getters and setters

    public int getNumInstructors() {
        return numInstructors;
    }

    public void setNumInstructors(int numInstructors) {
        this.numInstructors = numInstructors;
    }

    public int getNumCourses() {
        return numCourses;
    }

    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }

    public School(String name) {
        this.name = name;
        this.numInstructors = 0;
        this.numCourses = 0;
        this.numStudents = 0;
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }

    //TODO: public void readData(String file)
    //TODO: public void schoolInfo()
    //TODO: public boolean searchByEmail(String email)
    //TODO: public boolean addCourse(int code, String title)
    //TODO: public boolean deleteCourse(int code)
    //TODO: public boolean addInstructor(int number, String name, String email, String phone)
    //TODO: public boolean assignInstructor(int oldCode, int newCode)
    //TODO: public boolean register(int class, int id);

    public boolean searchByEmail(String email) {
        System.out.println("Search Key: " + email);
        for (Instructor i : this.instructors) {
            if (email.equals(i.getEmail())) {
                System.out.println("Employee Number: " + i.getNumber());
                System.out.println("Name: " + i.getName());
                System.out.println("Phone: " + i.getPhoneNumber());
                return true;
            }
        }
        System.out.println("No employee with email: " + email);
        return false;
    }

    public boolean assignInstructor(int )

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



    // helper functions for readData

    //adding students

    private boolean studentNumberAlreadyExists(String[] input) {
        for (Student i : this.students) {
            int id = Integer.parseInt(input[0]);
            if (i.getID() == id) {
                System.out.println("Student info reading failed – Student ID "+ id + " already used.");
                return true;
            }
        }
        return false;
    }

    private void inputStudents(String[] input) {
        if (!studentNumberAlreadyExists(input)) {
            int id = Integer.parseInt(input[0]);
            students.add(new Student(id, input[1]));
        }
    }

    //adding courses

    private boolean courseNumberAlreadyExists(String[] input) {
        for (Course i : this.courses) {
            int num = Integer.parseInt(input[0]);
            if (i.getCourseNum() == num) {
                System.out.println("Course addition failed – Course number " + num + " already used.");
                return true;
            }
        }
        return false;
    }

    private void inputCourses(String[] input) {
        if (!(courseNumberAlreadyExists(input))) {
            int courseNum = Integer.parseInt(input[0]);
            int cap = Integer.parseInt(input[2]);
            courses.add(new Course(courseNum, input[1], cap, input[3]));
        }
    }

    //adding teachers

    private boolean teacherNumberAlreadyExists(String[] input) {
        for (Instructor i : this.instructors) {
            int num = Integer.parseInt(input[0]);
            if (i.getNumber() == num) {
                System.out.println("Instructor info reading failed – Employee number " + num + " already used.");
                return true;
            }
        }
        return false;
    }

    private void inputTeachers(String[] input) {
        if (!(teacherNumberAlreadyExists(input))) {
            int num = Integer.parseInt(input[0]);
            instructors.add(new Instructor(num, input[1], input[2], input[3]));
        }
    }

    // public functions

    public void readData(String file) {
        //psoodocode
        /*
        read in an integer from file
        for loop, from i to n, for instructors
        constructor
        another for looop, for courses
        cosntructor
        another for loooop, for stoodents
        constructor
         */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
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
                        case 2: // TODO: inputting students into method
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


    public void schoolInfo() {
        System.out.println("School Name: " + this.name);
        System.out.println("Instructor Information: ");
        for (Instructor i : instructors) {
            System.out.println(i.getName());
        }
        System.out.println("Course Information: ");
        for (Course i : courses) {
            System.out.println(i.getCourseTitle());
        }
        System.out.println("Student Information: ");
        for (Student i : students) {
            System.out.println(i.getName());
        }
    }

}

/*
TODO:
fucking read in files -- readData(string file)
schoolInfo()
searchByEmail(string search)
addCourse(int n, string t);
addInstructor(int n, string name, string email, string phone)
assignInstructor(int old, int new);
register(int class, int id);

 */