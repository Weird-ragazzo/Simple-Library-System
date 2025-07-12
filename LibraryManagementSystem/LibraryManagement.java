package LibraryManagementSystem;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Issued: " + (isIssued ? "Yes" : "No"));
    }
}

public class LibraryManagement {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author name: ");
        String author = sc.nextLine();

        books.add(new Book(title, author));
        System.out.println("Book added successfully!\n");
    }

    public static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.\n");
            return;
        }
        System.out.println("\nBooks in library:");
        for (int i = 0; i < books.size(); i++) {
            System.out.print((i + 1) + ". ");
            books.get(i).displayInfo();
        }
        System.out.println();
    }

    public static void issueBook() {
        displayBooks();
        System.out.print("Enter book number to issue: ");
        int num = sc.nextInt();
        sc.nextLine(); 

        if (num <= 0 || num > books.size()) {
            System.out.println("Invalid book number.\n");
            return;
        }

        Book book = books.get(num - 1);
        if (book.isIssued) {
            System.out.println("Book already issued.\n");
        } else {
            book.isIssued = true;
            System.out.println("Book issued successfully!\n");
        }
    }

    public static void returnBook() {
        displayBooks();
        System.out.print("Enter book number to return: ");
        int num = sc.nextInt();
        sc.nextLine(); 

        if (num <= 0 || num > books.size()) {
            System.out.println("Invalid book number.\n");
            return;
        }

        Book book = books.get(num - 1);
        if (!book.isIssued) {
            System.out.println("Book was not issued.\n");
        } else {
            book.isIssued = false;
            System.out.println("Book returned successfully!\n");
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("----- Library Management System by Dhruv Raghav-----");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        } while (choice != 5);
    }
}
