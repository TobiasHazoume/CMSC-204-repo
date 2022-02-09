
import java.io.*;
import java.util.*;
/**
 * @author tobias
 *
 */
public class NoLowerAlphaException extends Exception{

	public NoLowerAlphaException() {
		super("The password must contain at least one uppercase alphabetic character\r\n"
				+ "Password doesn’t contain a lowercase alpha character\r\n"
				+ "");
	}

	public NoLowerAlphaException(String message) {
		super(message);
	}

}
