package models;

import java.time.LocalDate;

public class Borrowings {

    private Long id;
    private Book book;
    private User user ;
    private LocalDate issueDate;
    private LocalDate returnDate;
    public Borrowings(Book book, User user) {
        this.book = book;
        this.user = user;
        this.issueDate = LocalDate.now();
        this.returnDate = null;
    }
    public Long getId() {
        return id;
    }
    public Book getBook() {
        return book;
    }
    public User getUser() {
        return user;
    }
    public LocalDate getIssueDate() {
        return issueDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BorrowingRecords [id=" + id + ", book=" + book + ", user=" + user + ", issueDate=" + issueDate
                + ", returnDate=" + returnDate + "]";
    }   //






}
