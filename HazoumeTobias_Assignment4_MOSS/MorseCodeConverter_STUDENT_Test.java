import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * @author Tobias
 *
 */
public class MorseCodeConverter_STUDENT_Test {

	
	/**
	 * Testing for correct conversion of all characters using key phrase to hit all letters
	 */
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish("-- --- .-. ... . / -.-. --- -.. . / - .-. .- -. ... .-.. .- - --- .-. / - . ... -");
		assertEquals("morse code translator test", converter1);

	}
	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		/*Make sure LoveLooksNot.txt is in the src directory for this 
		  test to pass
		*/
		File file = new File("src/LoveLooksNot.txt"); 
		try {
			assertEquals("love looks not with the eyes but with the mind", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}
	

}
