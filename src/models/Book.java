package models;

import java.sql.Date;

public class Book {

    public enum Status{
        AVAILABLE,
        BORROWED
    }

    private Long id;
    private String title;
    private String isbn;
    private String author;
    private String language;
    private Status status;




    public Book (String isbn,String title, String author, String language) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.language = language;
        this.status = Status.AVAILABLE;

    }




    public Long getId() {
        return id;
    }




    public String getTitle() {
        return title;
    }




    public String getIsbn() {
        return isbn;
    }




    public String getAuthor() {
        return author;
    }




    public String getLanguage() {
        return language;
    }




    public Status getStatus() {
        return status;
    }




    public void setId(Long id) {
        this.id = id;
    }




    public void setTitle(String title) {
        this.title = title;
    }




    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }




    public void setAuthor(String author) {
        this.author = author;
    }




    public void setLanguage(String language) {
        this.language = language;
    }




    public void setStatus(Status status) {
        this.status = status;
    }




    @Override
    public String toString() {
        return "Book [title=" + title + ", isbn=" + isbn + ", author=" + author + ", language=" + language + ", status="
                + status + "]";
    }









}

