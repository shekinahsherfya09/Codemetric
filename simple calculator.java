 import java.util.Scanner;

public class SimpleCalculator {

    // Method for addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method for division with exception handling
    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        System.out.println("=== Simple Calculator ===");

        while (continueCalculation) {
            try {
                // Input numbers
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                // Choose operation
                System.out.println("Choose an operation:");
                System.out.println("1. Addition (+)");
                System.out.println("2. Subtraction (-)");
                System.out.println("3. Multiplication (*)");
                System.out.println("4. Division (/)");
                System.out.print("Enter your choice (1-4): ");
                int choice = scanner.nextInt();

                double result = 0;

                switch (choice) {
                    case 1:
                        result = add(num1, num2);
                        System.out.printf("Result: %.2f\n", result);
                        break;
                    case 2:
                        result = subtract(num1, num2);
                        System.out.printf("Result: %.2f\n", result);
                        break;
                    case 3:
                        result = multiply(num1, num2);
                        System.out.printf("Result: %.2f\n", result);
                        break;
                    case 4:
                        result = divide(num1, num2);
                        System.out.printf("Result: %.2f\n", result);
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1 to 4.");
                }
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.nextLine(); // clear buffer
            }

            // Ask to continue
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String continueInput = scanner.next();

            if (!continueInput.equalsIgnoreCase("yes")) {
                continueCalculation = false;
                System.out.println("Thank you for using the calculator. Goodbye!");
            }
        }

        scanner.close();
    }
}
