package services;

import java.util.List;

import models.Book;

public interface BookService {

    Book addBook(Book book);
    Book updateBook (Book updatedBook);
    //	boolean deleteBook(int id);
    List<Book>  viewAllBook();
    Book findBookById(Long id);
    boolean removeBook(Long id);

}
