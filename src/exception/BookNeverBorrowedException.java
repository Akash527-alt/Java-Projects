package exception;

public class BookNeverBorrowedException extends RuntimeException{
    String message;

    public BookNeverBorrowedException(String message){
        super(message);
    }

}
