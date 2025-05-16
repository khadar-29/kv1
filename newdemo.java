import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class newdemo {
    private String name;
    private LocalDate dob;

    newdemo(String name, String dobString) {
        this.name = name;
        this.dob = parseDate(dobString);
    }

    private LocalDate parseDate(String dobString) {
        try {
            if (dobString.matches("\\d{2}-\\d{2}-\\d{4}")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                return LocalDate.parse(dobString, formatter);
            } else if (dobString.matches("\\d{4}-\\d{2}-\\d{2}")) {
                return LocalDate.parse(dobString); // ISO format
            } else {
                throw new IllegalArgumentException("Invalid date format.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Date must be in DD-MM-YYYY or YYYY-MM-DD format.");
        }
    }

    public void displayStudentInfo() {
        LocalDate today = LocalDate.now();
        int age = Period.between(dob, today).getYears();
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Date of Birth (DD-MM-YYYY or YYYY-MM-DD): ");
        String dob = sc.nextLine();

        newdemo student = new newdemo(name, dob);
        student.displayStudentInfo();
        sc.close();
    }
} 


