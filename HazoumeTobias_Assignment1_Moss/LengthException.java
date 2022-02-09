
import java.io.*;
import java.util.*;
/**
 * @author tobias
 *
 */
public class LengthException extends Exception{

	public LengthException() {
		super("The password must be at least 6 characters long");
	}

	public LengthException(String message) {
		super(message);
	}

}
