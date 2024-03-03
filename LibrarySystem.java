

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

public class LibrarySystem {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Search for a book");
            System.out.println("3. Remove a book");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntegerInput();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private int getIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void addBook() {
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    private void searchBook() {
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter the title of the book to search for: ");
        String searchTitle = scanner.nextLine();
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                System.out.println("Book found: " + book);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    private void removeBook() {
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter the title of the book to remove: ");
        String removeTitle = scanner.nextLine();
        boolean removed = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(removeTitle)) {
                books.remove(book);
                removed = true;
                System.out.println("Book removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Book not found.");
        }
    }

    private void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
