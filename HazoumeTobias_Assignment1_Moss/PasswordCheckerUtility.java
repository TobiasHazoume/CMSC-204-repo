import java.util.ArrayList;
/**
 * Test the methods of PasswordChecker
 * @author Professor tobias
 *
 */
public class PasswordCheckerUtility {

	
	//the default (no-arg) constructor.
	PasswordCheckerUtility()
	{		
	}
	
	
	/**
	 * Compare equality of two passwords Parameters: password - password string to
	 * be checked for passwordConfirm - passwordConfirm string to be checked against
	 * password for Throws: UnmatchedException - thrown if not same (case sensitive)
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords​(java.lang.String password, java.lang.String passwordConfirm)
			throws UnmatchedException {

		try {
			password.equals(passwordConfirm); // this is it i dont have to return anything?
			if (!password.equals(passwordConfirm)) {
				throw new UnmatchedException();
			}

		} catch (UnmatchedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Compare equality of two passwords Parameters: password - password string to
	 * be checked for passwordConfirm - passwordConfirm string to be checked against
	 * password for Returns: true if both same (case sensitive), false otherwise
	 *
	 * @param password
	 * @param passwordConfirm
	 * @return
	 */
	public static boolean comparePasswordsWithReturn​(java.lang.String password, java.lang.String passwordConfirm) {
		// make an if statement and use the equals method for password and
		// passwordConfirm to see if they match
		// store the result in boolean is true and return said value
		boolean comparePasswords;

		password.equals(passwordConfirm);
		if (!password.equals(passwordConfirm)) {
			comparePasswords = false;
		} else {
			comparePasswords = true;

		}
		return comparePasswords;
	}

	/**
	 * Checks the password length requirement - The password must be at least 6
	 * characters long Parameters: password - password string to be checked for
	 * length Returns: true if meets minimum length requirement Throws:
	 * LengthException - thrown if does not meet minimum length requirement
	 * @param password
	 * @return
	 * @throws LengthException
	 */
	public static boolean isValidLength​(java.lang.String password) throws LengthException {
		boolean validLength = false;
		try {
			// check the length of password using password.length()
			if (password.length() >= 6) {
				validLength = true;
			} else {
				validLength = false;
				throw new LengthException();
			}

		} catch (LengthException e) {
			e.printStackTrace();
		}

		return validLength;
	}

	/**
	 * Checks the password alpha character requirement - Password must contain an
	 * uppercase alpha character Parameters: password - password string to be
	 * checked for alpha character requirement Returns: true if meet alpha character
	 * requirement Throws: NoUpperAlphaException - thrown if does not meet alpha
	 * character requirement
	 * @param password
	 * @return
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha​(java.lang.String password) throws NoUpperAlphaException {
		boolean upperAlpha = false;
		try {
			upperAlpha = !password.equals(password.toUpperCase()); //
			throw new NoUpperAlphaException();
		} catch (NoUpperAlphaException e) {
			e.printStackTrace();
		}

		return upperAlpha;
	}

	/**
	 * Checks the password lowercase requirement - Password must contain at least
	 * one lowercase alpha character Parameters: password - password string to be
	 * checked for lowercase requirement Returns: true if meets lowercase
	 * requirement Throws: NoLowerAlphaException - thrown if does not meet lowercase
	 * requirement
	 * @param password
	 * @return
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha​(java.lang.String password) throws NoLowerAlphaException {
		boolean lowerAlpha = false;
		try {
			lowerAlpha = !password.equals(password.toLowerCase());
			throw new NoLowerAlphaException();
		} catch (NoLowerAlphaException e) {
			e.printStackTrace();
		}

		return lowerAlpha;
	}

	/**
	 * Checks the password Digit requirement - Password must contain a numeric
	 * character Parameters: password - password string to be checked for Digit
	 * requirement Returns: true if meet Digit requirement Throws: NoDigitException
	 * - thrown if does not meet Digit requirement
	 * @param password
	 * @return
	 * @throws NoDigitException
	 */
	public static boolean hasDigit​(java.lang.String password) throws NoDigitException {
		boolean digit = false;

		try {
			digit = password.matches(".*\\d+.*");
			throw new NoDigitException();
		} catch (NoDigitException e) {
			e.printStackTrace();
		}
		return digit;

	}

	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a
	 * Special Character Parameters: password - password string to be checked for
	 * SpecialCharacter requirement Returns: true if meets SpecialCharacter
	 * requirement Throws: NoSpecialCharacterException - thrown if does not meet
	 * SpecialCharacter requirement
	 * @param password
	 * @return
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar​(java.lang.String password) throws NoSpecialCharacterException {
		boolean specialChar = false;
		try {
			specialChar = !password.matches("[A-Za-z0-9 ]*");// uses regex to if the string contains a special char
			throw new NoSpecialCharacterException();
		} catch (NoSpecialCharacterException e) {
			e.printStackTrace();
		}
		return specialChar;
	}

	/**
	 * change​ Checks the password Sequence requirement - Password should not
	 * contain more than 2 of the same character in sequence Parameters: password -
	 * password string to be checked for Sequence requirement Returns: false if does
	 * NOT meet Sequence requirement Throws: InvalidSequenceException - thrown if
	 * meets Sequence requirement
	 * @param password
	 * @return
	 * @throws InvalidSequenceException
	 */
	public static boolean noSameCharInSequence(java.lang.String password) throws InvalidSequenceException {
		boolean sameCharInSequence​ = false;
		// No more than 2 of the same character in a sequence - Hello@123 – OK AAAbb@123
		// – not OK Aaabb@123 – OK
		try {
			int j = password.length();
			for (int i = 2; i <= j; i++) { // should i use < or <=???
				if (password.charAt(i) == password.charAt(i - 1) && (password.charAt(i) == password.charAt(i - 2))) {
					sameCharInSequence​ = false;
				} else {
					sameCharInSequence​ = true;
					throw new InvalidSequenceException();
				}
			}
		} catch (InvalidSequenceException e) {
			e.printStackTrace();
		}

		return sameCharInSequence​;
		// ​
	}

	/**
	 * Return true if valid password (follows all the following rules), returns
	 * false if an invalid password 1. At least 6 characters long 2. At least 1
	 * uppercase alphabetic character 3. At least 1 lowercase alphabetic character 4
	 * At least 1 numeric character 5. At least 1 special character 6. No more than
	 * 2 of the same character in a sequence - Hello@123 – OK AAAbb@123 – not OK
	 * Aaabb@123 – OK Parameters: password - - string to be checked for validity
	 * Returns: true if valid password (follows all rules from above), false if an
	 * invalid password Throws: LengthException - thrown if length is less than 6
	 * characters NoUpperAlphaException - thrown if no uppercase alphabetic
	 * NoLowerAlphaException - thrown if no lowercase alphabetic NoDigitException -
	 * thrown if no digit NoSpecialCharacterException - thrown if does not meet
	 * SpecialCharacter requirement InvalidSequenceException - thrown if more than 2
	 * of same character.
	 * @param password
	 * @return
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword​(java.lang.String password) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		boolean validPassword = false;
		try {


			if (isValidLength​(password) == false) {
				validPassword = false;
				throw new LengthException();
			} else {
				validPassword = true;
			}

		} catch (LengthException e) {
			e.printStackTrace();
		}

		try {
			validPassword = !password.equals(password.toUpperCase()); //
			throw new NoUpperAlphaException();
		} catch (NoUpperAlphaException e) {
			e.printStackTrace();
		}

		try {
			validPassword = !password.equals(password.toLowerCase());
			throw new NoLowerAlphaException();
		} catch (NoLowerAlphaException e) {
			e.printStackTrace();
		}

		try {
			validPassword = password.matches(".*\\d+.*");
			throw new NoDigitException();
		} catch (NoDigitException e) {
			e.printStackTrace();
		}

		try {
			int j = password.length();
			for (int i = 2; i <= j; i++) { // should i use < or <=???
				if (password.charAt(i) == password.charAt(i - 1) && (password.charAt(i) == password.charAt(i - 2))) {
					validPassword = false;
				} else {
					validPassword = true;
					throw new InvalidSequenceException();
				}
			}
		} catch (InvalidSequenceException e) {
			e.printStackTrace();
		}

		return validPassword;

	}

	/**
	 * checks if the password contains 6 to 9 characters Parameters: password -
	 * password string to be checked for Returns: true if password contains 6 to 9
	 * characters, false otherwise
	 * @param password
	 * @return
	 */
	public static boolean hasBetweenSixAndNineChars​(java.lang.String password) {
		boolean betweenSixAndNineChars;

		if (password.length() > 5 && password.length() < 10) {
			betweenSixAndNineChars = true;
		} else {
			betweenSixAndNineChars = false;
		}
		return betweenSixAndNineChars;
	}

	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * Parameters: password - string to be checked if weak password Returns: false
	 * if the password is valid and the length of password is NOT between 6 and 9
	 * (inclusive). Throws: WeakPasswordException - if length of password is between
	 * 6 and 9 (inclusive), ALTHOUGH the password may be VALID.
	 * @param password
	 * @return
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword​(java.lang.String password) throws WeakPasswordException {
		boolean weakPassword = false;

		try {

			if (!(password.length() > 5 && password.length() < 10)) {
				weakPassword = true;
			} else {
				weakPassword = false;
				throw new WeakPasswordException();


			}

		} catch (WeakPasswordException e) {
			e.printStackTrace();
		}

		try {
			weakPassword = !password.equals(password.toUpperCase()); //
			throw new NoUpperAlphaException();
		} catch (NoUpperAlphaException e) {
			e.printStackTrace();
		}

		try {
			weakPassword = !password.equals(password.toLowerCase());
			throw new NoLowerAlphaException();
		} catch (NoLowerAlphaException e) {
			e.printStackTrace();
		}

		try {
			weakPassword = password.matches(".*\\d+.*");
			throw new NoDigitException();
		} catch (NoDigitException e) {
			e.printStackTrace();
		}

		try {
			int j = password.length();
			for (int i = 2; i <= j; i++) { // should i use < or <=???
				if (password.charAt(i) == password.charAt(i - 1) && (password.charAt(i) == password.charAt(i - 2))) {
					weakPassword = false;
				} else {
					weakPassword = true;
					throw new InvalidSequenceException();
				}
			}
		} catch (InvalidSequenceException e) {
			e.printStackTrace();
		}

		return weakPassword;
	}

	/**
	 * 
	 * This method will accept an ArrayList of passwords as the parameter and return
	 * an ArrayList with the status of any invalid passwords (weak passwords are not
	 * considered invalid). The ArrayList of invalid passwords will be of the
	 * following format: password BLANK message of the exception thrown Parameters:
	 * passwords - list of passwords Returns: ArrayList of invalid passwords in the
	 * correct format
	 * @param passwords
	 * @return
	 */
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords​(
			java.util.ArrayList<java.lang.String> passwords) {
		ArrayList<String> passwordList = new ArrayList<String>();

		for (int i = 0; i < passwords.size(); i++) {
			try {
				if (isValidPassword​(passwords.get(i))) {
					passwordList.add(passwords.get(i));
				} else {
					passwordList.add(passwords.get(i) + " BLANK");

				}
			} catch (LengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoUpperAlphaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoLowerAlphaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoDigitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSpecialCharacterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidSequenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return passwordList;
	}

}
