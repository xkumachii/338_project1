public class Instructor {

    //fields
    private int number;
    private String name;
    private String email;
    private String phoneNumber;
    private int currentCourse;

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

    public int getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(int currentCourse) {
        this.currentCourse = currentCourse;
    }

    //constructor


    public Instructor(int number, String name, String email, String phoneNumber) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.currentCourse = 0;
    }
}
