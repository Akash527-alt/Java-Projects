package exceptions;

public class EmployeeLimitReachedException extends RuntimeException 
{
	public EmployeeLimitReachedException(String message) {
		super(message);
	}

}
