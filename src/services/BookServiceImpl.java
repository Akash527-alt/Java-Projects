package services;

import java.util.ArrayList;
import java.util.List;

import exception.BookNotFoundException;
import exception.NoBooksAvailableException;
import models.Book;
import repositories.BookRepository;

public class BookServiceImpl implements BookService {

    BookRepository bookRepo;

    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book addBook(Book book) {

        return bookRepo.addBook(book);
    }

    @Override
    public Book updateBook(Book updatedBook) {
        Book book = bookRepo.updateBook(updatedBook);

        return book;
    }

    @Override
    public List<Book> viewAllBook() {
        List<Book> books = bookRepo.viewAllBook();
        if(books == null || books.isEmpty()) {
            throw new NoBooksAvailableException("no books available for now");
        }
        return books;

    }

    @Override
    public Book findBookById(Long id) {
        Book book = bookRepo.findBookById(id);
        if(book == null) {
            throw new BookNotFoundException("book with given id is not availble");
        }
        return book;
    }

    @Override
    public boolean removeBook(Long id) {

        boolean bookRemoved = bookRepo.removeBook(id);
        if(bookRemoved == false) {
            throw new BookNotFoundException("book with given id is not availble");
        }
        return true;
    }


}
