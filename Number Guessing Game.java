import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int secretNumber = rand.nextInt(100) + 1; 
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        while (true) {
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine();

            try {
                int guess = Integer.parseInt(input);
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }

        scanner.close();
    }
}
