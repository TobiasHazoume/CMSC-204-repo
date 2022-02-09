
import java.io.*;
import java.util.*;
/**
 * @author tobias
 *
 */
public class NoSpecialCharacterException extends Exception{

	public NoSpecialCharacterException() {
		super("The password must contain at least one digit Password doesn’t contain a special character");
	}

	public NoSpecialCharacterException(String message) {
		super(message);
	}

}
