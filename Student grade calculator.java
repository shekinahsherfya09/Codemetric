import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;
    String grade;

    // Constructor
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
        calculateGrade();
    }

    // Method to calculate grade using if-else
    void calculateGrade() {
        if (marks >= 90) {
            grade = "A+";
        } else if (marks >= 80) {
            grade = "A";
        } else if (marks >= 70) {
            grade = "B";
        } else if (marks >= 60) {
            grade = "C";
        } else if (marks >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
    }
}

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();

            int marks;
            while (true) {
                System.out.print("Marks (0 to 100): ");
                if (scanner.hasNextInt()) {
                    marks = scanner.nextInt();
                    if (marks >= 0 && marks <= 100) {
                        break;
                    } else {
                        System.out.println("❌ Marks should be between 0 and 100.");
                    }
                } else {
                    System.out.println("❌ Invalid input. Please enter a number.");
                    scanner.next(); // consume invalid input
                }
            }
            scanner.nextLine(); // consume newline
            students.add(new Student(name, marks));
        }

        // Display report
        System.out.println("\n===== Student Grade Report =====");
        for (Student s : students) {
            System.out.println("Name: " + s.name);
            System.out.println("Marks: " + s.marks);
            System.out.println("Grade: " + s.grade);
            System.out.println("----------------------");
}

        scanner.close();
    }
}
