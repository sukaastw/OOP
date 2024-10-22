import java.util.ArrayList;

public class Student extends Person {
    String nim;
    String name;
    ArrayList<Course> courses;

    public Student(String nim, String name) {
        this.nim = nim;
        this.name = name;
        this.courses = new ArrayList<Course>();
    }

    public void printStudentDetails() {
        System.out.println("nim: " + nim);
        System.out.println("name: " + name);
        System.out.println("courses: " + courses);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(String code, String name) {
        courses.add(new Course(code, name));
    }

    public void removeCourse(String code) {
        courses.removeIf(course -> course.getCode().equals(code));
    }

    public String getName() {
        return name;
    }
}
