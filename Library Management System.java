import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " - " + (isAvailable ? "Available" : "Not Available");
    }
}

public class LibraryManagementSystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 5.");
                scanner.next(); // Clear invalid input
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> addBook();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> displayBooks();
                case 5 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine().trim();

        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    static void borrowBook() {
        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.nextLine().trim();

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.isAvailable) {
                    book.isAvailable = false;
                    System.out.println("You have borrowed \"" + book.title + "\".");
                } else {
                    System.out.println("Sorry, \"" + book.title + "\" is currently not available.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void returnBook() {
        System.out.print("Enter the title of the book to return: ");
        String title = scanner.nextLine().trim();

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (!book.isAvailable) {
                    book.isAvailable = true;
                    System.out.println("Thank you for returning \"" + book.title + "\".");
                } else {
                    System.out.println("This book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\nLibrary Book List:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
