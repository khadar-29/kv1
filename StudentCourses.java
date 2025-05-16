import java.util.HashMap;
import java.util.Map;

public class StudentCourses {
    private Map<String, Map<String, Integer>> semesterCourses = new HashMap<>();

    public void addCourse(String semester, String courseName, int marks) {
        semesterCourses.putIfAbsent(semester, new HashMap<>());
        semesterCourses.get(semester).put(courseName, marks);
    }

    public void displayCourses() {
        for (String semester : semesterCourses.keySet()) {
            System.out.println("\nSemester: " + semester);
            for (Map.Entry<String, Integer> entry : semesterCourses.get(semester).entrySet()) {
                System.out.println("  " + entry.getKey() + ": " + entry.getValue() + " marks");
            }
        }
    }

    public static void main(String[] args) {
        StudentCourses sc = new StudentCourses();
        sc.addCourse("Semester 1", "Mathematics", 88);
        sc.addCourse("Semester 1", "English", 75);
        sc.addCourse("Semester 2", "Computer Science", 91);
        sc.displayCourses();
    }
}