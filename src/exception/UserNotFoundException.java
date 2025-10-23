package exception;

public class UserNotFoundException extends RuntimeException{
    String message;

    public UserNotFoundException(String message) {
        super(message);
    }

//	public UserNotFoundException(String message2) {
    // TODO Auto-generated constructor stub
//	}

}