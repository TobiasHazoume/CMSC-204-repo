
import java.io.*;
import java.util.*;
/**
 * @author tobias
 *
 */
public class NoDigitException extends Exception{

	public NoDigitException() {
		super("The password must contain at least one lowercase alphabetic character\r\n"
				+ "Password doesn’t contain a numeric character\r\n"
				+ "");
	}

	public NoDigitException(String message) {
		super(message);
	}

}
