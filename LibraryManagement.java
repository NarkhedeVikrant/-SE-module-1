package org.tcs;
import java.util.*;

class Book {
    int id;
    String title, author, category;

    public Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Category: " + category;
    }
}

public class LibraryManagement {
    private static List<Book> books = new ArrayList<>();
    private static String password = "admin123";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();
        if (!inputPassword.equals(password)) {
            System.out.println("Incorrect password. Exiting...");
            return;
        }
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Search Book");
            System.out.println("4. View All Books");
            System.out.println("5. Change Password");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1: addBook(); break;
                case 2: deleteBook(); break;
                case 3: searchBook(); break;
                case 4: viewBooks(); break;
                case 5: changePassword(); break;
                case 6: 
                    System.out.println("Exiting in 3 seconds...");
                    try { Thread.sleep(3000); } catch (InterruptedException e) {}
                    return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }
    
    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        books.add(new Book(id, title, author, category));
        System.out.println("Book added successfully.");
    }
    
    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = scanner.nextInt();
        books.removeIf(book -> book.id == id);
        System.out.println("Book deleted if found.");
    }
    
    private static void searchBook() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }
    
    private static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    
    private static void changePassword() {
        System.out.print("Enter old password: ");
        String oldPassword = scanner.nextLine();
        if (!oldPassword.equals(password)) {
            System.out.println("Incorrect password.");
            return;
        }
        System.out.print("Enter new password: ");
        password = scanner.nextLine();
        System.out.println("Password changed successfully.");
    }
}
