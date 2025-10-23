package RunProgram;

import controllers.LibraryManagementController;
import models.Book;
import models.User;
import repositories.BookRepository;
import repositories.BookRepositoryImpl;
import repositories.UserRepository;
import repositories.UserRepositoryImpl;
import repositories.BorrowingsRepositoryImpl;
import repositories.BorrowingsRepository;
import services.*;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepo = new UserRepositoryImpl();
        BookRepository bookRepo  = new BookRepositoryImpl();
        BorrowingsRepository borrowingsRepo = new BorrowingsRepositoryImpl();

        LibraryService libraryService = new LibraryServiceImpl(userRepo,bookRepo,borrowingsRepo);
        BookService bookService  = new BookServiceImpl(bookRepo);
        UserService userService = new service.UserServiceImpl(userRepo);
        addSampleData(userService, bookService);

        LibraryManagementController controller = new LibraryManagementController(libraryService,userService,bookService);
        controller.run();

    }

    private static void addSampleData(UserService userService, BookService bookService ) {
        System.out.println("Setting up initial library data...");

        // Add users (User ID 1 and 2 will be created)
        userService.addUser(new User("Alice Smith", "alice@email.com", "pass123"));
        userService.addUser(new User("Bob Johnson", "bob@email.com", "pass456"));

        // Add books (Book ID 1, 2, and 3 will be created)
        bookService.addBook(new Book("9780743273565", "The Great Gatsby", "F. Scott Fitzgerald","English"));
        bookService.addBook(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee","Spanish"));
        bookService.addBook(new Book("9780451524935", "1984", "George Orwell","English"));

        System.out.println("Setup complete!");
        System.out.println("Users created: Alice (ID: 1), Bob (ID: 2)");
        System.out.println("Books created: Gatsby (ID: 1), Mockingbird (ID: 2), 1984 (ID: 3)");
    }

}
