package controllers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import exception.BookNeverBorrowedException;
import exception.BookNotFoundException;
import exception.NoBooksAvailableException;
import exception.UserNotFoundException;
import models.Book;
import services.BookService;
import services.LibraryService;
import services.UserService;

public class LibraryManagementController {


    private LibraryService libraryService;
    private UserService userService;
    private BookService bookService;

    Scanner scanner;

    public LibraryManagementController(LibraryService libraryService, UserService userService,BookService bookService) {
        this.libraryService = libraryService;
        this.userService = userService;
        this.bookService = bookService;
        this.scanner = new Scanner(System.in);
    }


    public void run() {
        while(true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adminMenu(scanner);
                    break;
                case 2:
                    userMenu(scanner);
                    break;

                case 3:
                    System.out.println(	"Thanks for visiting Library ! GoodBye");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice please try again");
            }
        }
    }

    private void adminMenu(Scanner scanner) {

        while(true) {
            System.out.println("\n === Admin Menu ====");
            System.out.println("1. Add a new Book ");
            System.out.println("2. view all books ");
            System.out.println("3. Remove a book ");
            System.out.println("4. show all books borrowed by user");
            System.out.println("5. Return to main Menu ");
            System.out.println(" plese choose and option");


            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option) {
                case 1:
                    addbook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    booksBorrowedByuser();
                    break;
                case 5:
                    System.out.println("Returning to main menu.....");
                    return ;
                default:
                    System.out.println("Invalid choice , please choose correct option");

            }


        }

    }


    private void removeBook() {
        System.out.println("Enter Book id to remove ");
        Long bId = scanner.nextLong();
        try {
            bookService.removeBook(bId);
            System.out.println("Book with ID: "+bId+" remove successfully");
        }
        catch(BookNotFoundException e) {
            System.out.println("Error: "+e.getMessage());
        }

    }


    private void viewAllBooks() {


        try {
            List<Book> bookList = bookService.viewAllBook();
            for(Book book:bookList) {
                System.out.println(book);
            }

        }
        catch(NoBooksAvailableException e) {
            System.out.println("Error: "+ e.getMessage());

        }



    }


    private void addbook() {
        System.out.println("Enter ISBN Number ");
        String isbn = scanner.nextLine();
        System.out.println("Enter book title ");
        String title = scanner.nextLine();
        System.out.println("Enter book Author name");
        String author = scanner.nextLine();
        System.out.println("Enter book language ");
        String lang = scanner.nextLine();
        bookService.addBook(new Book(isbn,title,author,lang));
        System.out.println("Book added successfully: ");


    }


    private void userMenu(Scanner scanner) {

        while(true) {
            System.out.println("\n===== User Menu ====");
            System.out.println("1. List all available Books");
            System.out.println("2. Borrow a Book ");
            System.out.println("3. Return borrowed book ");
            System.out.println("4. show all books borrowed by user");
            System.out.println("5. Exit  ");
            System.out.println("Enter your choice ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    listAvailableBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    booksBorrowedByuser();
                    break;
                case 5:
                    System.out.println(	"Going back to Main menu......");
                    return;
                default:
                    System.out.println("Invalid choice please try again");

            }



        }

    }


    private void printMenu() {
        System.out.println("\n===== Welcome to library ====");
        System.out.println("1. Admin Interface");
        System.out.println("2. User Interface ");
        System.out.println("3. Exit ");

    }


    private void booksBorrowedByuser() {
        System.out.print("Enter user Id to see their books borrowed ");
        try{
            Long userId = scanner.nextLong();
            List<Book> borrowed = libraryService.findBooksBorrowedByUsers(userId);
            if(borrowed == null || borrowed.isEmpty()){
                System.out.println("no books borrowed by the user "+userId);
            }
            else{
                borrowed.forEach(System.out::println);
            }
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input! Please enter numbers.");
            scanner.nextLine(); // clear buffer
        }
        catch(UserNotFoundException e) {
            System.out.println("Error: "+e.getMessage());
            return;
        }


    }


    private void returnBook() {
        System.out.println("Enter BookId to Return book");
        try {
            Long bookId = scanner.nextLong();
            libraryService.returnBook(bookId);
            System.out.println("Book returned Successfully ");
        }
        catch(InputMismatchException e){    // catch exceptions
            System.out.println("Invalid input! Please enter numbers.");
            scanner.nextLine(); // clear buffer
        }
        catch(BookNotFoundException | BookNeverBorrowedException e) {
            System.out.println("Error: "+e.getMessage());

        }

    }

    private void borrowBook() {
        System.out.println("Enter your User ID: ");

        try {
            Long userId = scanner.nextLong();
            System.out.println("Enter the Book Id to Borrow");
            Long bookId = scanner.nextLong();
            libraryService.borrowBooks(bookId, userId);
            System.out.println("Book borrowed Successfully ");
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input! Please enter numbers.");
            scanner.nextLine(); // clear buffer
        }
        catch(BookNotFoundException | UserNotFoundException | NoBooksAvailableException e) {
            System.out.println("Error: "+e.getMessage());
        }

    }





    private void listAvailableBooks() {
        System.out.println("\n-- Available Books -- ");
        List<Book> availableBooks = libraryService.findAvailableBooks();
        if(availableBooks.isEmpty()) {
            System.out.println("no books are currently available");
        }
        else {
            availableBooks.forEach(System.out::println);
        }
    }



}

