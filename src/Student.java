public class Student {

    //fields

    private int ID;
    private String name;
    private int currentCourse;

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

    public int getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(int currentCourse) {
        this.currentCourse = currentCourse;
    }

    // constructor

    public Student(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.currentCourse = 0;
    }

}
