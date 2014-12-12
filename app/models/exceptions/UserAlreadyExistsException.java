package models.exceptions;

public class UserAlreadyExistsException extends Exception {

	public UserAlreadyExistsException()
    {
        super("Dieser User existiert bereits!");
    }
}
