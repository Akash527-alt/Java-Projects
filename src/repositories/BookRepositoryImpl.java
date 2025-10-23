package repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Book;

public class BookRepositoryImpl implements BookRepository{

    private List<Book> books = new ArrayList<>();
    private Long bookId= 1L;


    @Override
    public Book addBook(Book book) {
        if(book.getId() == null) {
            book.setId(bookId);
            bookId++;
        }

        books.add(book);
        return book;
    }

    @Override
    public Book updateBook(Book updatedBook) {
        for(int i = 0;i<books.size();i++) {
            Book currentBook = books.get(i);

            if(currentBook.getId().equals(updatedBook.getId())) {
                books.set(i, currentBook);
                return updatedBook;
            }
        }
        return null;
    }

    @Override
    public boolean removeBook(Long id) {

        return books.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public List<Book> viewAllBook() {

        return new ArrayList<>(books);
    }

    @Override
    public Book findBookById(Long id) {
        for(Book book : books) {
            if(book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

}
