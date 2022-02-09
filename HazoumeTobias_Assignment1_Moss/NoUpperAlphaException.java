
import java.io.*;
import java.util.*;
/**
 * @author tobias
 *
 */
public class NoUpperAlphaException extends Exception{

	public NoUpperAlphaException() {
		super("The password must be at least 6 characters long\r\n"
				+ "Password doesn’t contain an uppercase alpha character\r\n"
				+ "");
	}

	public NoUpperAlphaException(String message) {
		super(message);
	}

}
