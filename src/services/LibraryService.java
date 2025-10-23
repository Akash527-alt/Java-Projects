package services;

import java.util.List;

import models.Book;
import models.Borrowings;

public interface LibraryService {

    void borrowBooks(Long bookId, Long userId);
    void returnBook(Long bookId);
    List<Book> findAvailableBooks();
    List<Book> findBooksBorrowedByUsers(Long userId);
}
