package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.BookNeverBorrowedException;
import exception.BookNotFoundException;
import exception.NoBooksAvailableException;
import exception.UserNotFoundException;
import models.Book;
import models.Borrowings;
import models.User;
import repositories.BookRepository;
import repositories.BorrowingsRepository;
import repositories.UserRepository;

public class LibraryServiceImpl implements LibraryService{

    private UserRepository userRepo;
    private BookRepository bookRepo;
    private BorrowingsRepository borrowingRepo;

    public LibraryServiceImpl(UserRepository userRepo,BookRepository bookRepo,BorrowingsRepository borrowingRepo) {
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
        this.borrowingRepo = borrowingRepo;
    }


    @Override
    public void borrowBooks(Long bookId, Long userId) {
        Book book = bookRepo.findBookById(bookId);
        if(book == null) {
            throw new BookNotFoundException("Book with " + bookId + " is not found");
        }

        User user = userRepo.findById(userId);
        if(user == null) {
            throw new UserNotFoundException("User with "+userId+" not available");
        }



        if(book.getStatus() == Book.Status.BORROWED) {
            throw new NoBooksAvailableException("Book is currently borrowed other person");
        }

        book.setStatus(Book.Status.BORROWED);
        bookRepo.updateBook(book);

        Borrowings newRecord = new Borrowings(book,user);
        borrowingRepo.addNewRecord(newRecord);

        System.out.println("Success: "+user.getName() + " borrowed " + book.getTitle());

    }

    @Override
    public void returnBook(Long bookId) {
        Book book = bookRepo.findBookById(bookId);
        if(book == null) {
            throw new BookNotFoundException("book with ID: " + bookId + " not found");
        }

        Borrowings borrowed = borrowingRepo.findActiveBorrowedByBoodId(bookId);
        if(borrowed == null ) {
            throw new BookNeverBorrowedException("Book with ID: "+bookId + " was never borrowed");
        }

        book.setStatus(Book.Status.AVAILABLE);
        bookRepo.updateBook(book);

        borrowed.setReturnDate(LocalDate.now());



        System.out.println(book.getTitle()+" Successfully Returned "  );


    }

    @Override
    public List<Book> findAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for(Book book : bookRepo.viewAllBook()) {
            if(book.getStatus() == Book.Status.AVAILABLE) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }


    @Override
    public List<Book> findBooksBorrowedByUsers(Long userId) {
        List<Book> borrowedBooks = new ArrayList<>();


        User user = userRepo.findById(userId);
        if(user == null ) {
            throw new UserNotFoundException("User with ID:" + userId + " not found");

        }
        List<Borrowings> userRecords = borrowingRepo.findRecordByUserId(userId);


        for(Borrowings record: userRecords) {
            if(record.getReturnDate() == null) {
                borrowedBooks.add(record.getBook());
            }
        }
        return borrowedBooks;
    }

}
