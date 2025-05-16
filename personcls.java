import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void displayPersonName() {
        System.out.println("Name: " + name);
    }

    public void displayAge(String dob) {
        LocalDate birthDate = parseDate(dob);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        System.out.println("Age: " + age.getYears() + " years");
    }

    private LocalDate parseDate(String dob) {
        DateTimeFormatter formatter;
        if (dob.contains("-") && dob.length() == 10) {
            // DD-MM-YYYY or YYYY-MM-DD
            if (Character.isDigit(dob.charAt(0)) && Character.isDigit(dob.charAt(1))) {
                formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            } else {
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            }
        } else {
            throw new IllegalArgumentException("Invalid date format.");
        }
        return LocalDate.parse(dob, formatter);
    }
}

class Employee extends Person {
    private int empId;
    private double salary;

    public Employee(String name, int empId, double salary) {
        super(name);
        this.empId = empId;
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        displayPersonName();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: $" + salary);
    }
}

public class personcls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Person
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter date of birth (DD-MM-YYYY or YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        // Input for Employee
        System.out.print("Enter employee ID: ");
        int empId = scanner.nextInt();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        // Create and use Employee object
        Employee emp = new Employee(name, empId, salary);
        emp.displayEmployeeDetails();
        emp.displayAge(dob);
        scanner.close();
    }
}