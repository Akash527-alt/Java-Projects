package exception;

public class BookNotFoundException extends RuntimeException{
    String message ;

    public BookNotFoundException(String message){
        super(message);
    }

}

