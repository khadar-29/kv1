import java.util.ArrayList;
import java.util.List;

class Course {
    String courseName;
    int marks;

    public Course(String courseName, int marks) {
        this.courseName = courseName;
        this.marks = marks;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMarks() {
        return marks;
    }
}

class Student {
    String name;
    String program;
    int semester;
    List<Course> courses = new ArrayList<>();

    public Student(String name, String program, int semester) {
        this.name = name;
        this.program = program;
        this.semester = semester;
    }

    public void registerCourse(Course course) {
        courses.add(course);
    }

    public void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Program: " + program);
        System.out.println("Semester: " + semester);
        System.out.println("Registered Courses:");
        for (Course c : courses) {
            System.out.println(" - " + c.getCourseName());
        }
    }

    public void displayLowMarks() {
        System.out.println("\nCourses with marks less than 40:");
        for (Course c : courses) {
            if (c.getMarks() < 40) {
                System.out.println(" - " + c.getCourseName() + ": " + c.getMarks());
            }
        }
    }
}

public class main {
    public static void Main(String[] args) {
        Student student = new Student("Alice", "B.Tech CSE", 5);

        student.registerCourse(new Course("Mathematics", 85));
        student.registerCourse(new Course("Data Structures", 38));
        student.registerCourse(new Course("Operating Systems", 45));
        student.registerCourse(new Course("Algorithms", 30));

        student.displayStudentDetails();
        student.displayLowMarks();
    }
}