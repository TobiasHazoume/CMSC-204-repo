
import java.io.*;
import java.util.*;
/**
 * @author tobias
 *
 */
public class WeakPasswordException extends Exception{

	public WeakPasswordException() {
		super("Password contains 6 to 9 characters which are otherwise valid");
	}

	public WeakPasswordException(String message) {
		super(message);
	}

}
