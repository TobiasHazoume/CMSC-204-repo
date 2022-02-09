
import java.io.*;
import java.util.*;
/**
 * @author tobias
 *
 */
public class UnmatchedException extends Exception{

	public UnmatchedException() {
		super("Check if Password and re-typed Password are identical");
	}

	public UnmatchedException(String message) {
		super(message);

	}

	
}


