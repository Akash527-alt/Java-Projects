package exception;

public class NoBooksAvailableException extends RuntimeException{

    String message;

    public NoBooksAvailableException(String message){
        super(message);
    }

}