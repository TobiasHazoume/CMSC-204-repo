import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Tobias
 *
 */
public class MorseCodeConverter{
	
	
	//calls the constructor for the MorseCodeTree.
	private static MorseCodeTree tree = new MorseCodeTree();
	
	//not sure is this is right
	public MorseCodeConverter()
	{
		
	}
	
	/**
	 * Converts Morse code into English. 
	 * Each letter is delimited by a space (‘ ‘). 
	 * Each word is delimited by a ‘/’. 
	 * 
	 * Example:
	 *	code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
	 *	string returned = "Hello World"
	 * 
	 * @param code morse code
	 * @return the code in english
	 */
	public static String convertToEnglish(String code)
	{
		String[] words;
		String[] letters;
		String result="";
		// dash is a space so it will split up each word 
		//in the morse code and store it into an arraay 
		words=code.split("/"); 
		// this will loop though each word in the in codeWords
		for(int i=0;i<words.length;i++) {
			//will  removes whitespace from both ends of a string w/o
			//change anything in between
			words[i]=words[i].trim();
			//splits the morse code word into letters and store them in an array
			letters=words[i].split(" ");
			//lopp thorugh each letter in a word and decrypts it
			for(int j=0;j<letters.length;j++) {
				//store the dycrption into result
				result+=tree.fetch(letters[j]);
			}
			//outputs a space once youre done dycrypting a word
			result+=" ";
		}
		
		//removes whitespace from both ends of a string w/o
		//change anything in between
		result=result.trim();
		//return the morse code in english
		return result;
	}
	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘).
	 * 
	 * @param codeFile - name of the File that contains Morse Code
	 * @return  the code in english
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException 
	{

		
		String codes = "";
		Scanner in = new Scanner(codeFile);
		
		//read the code in the txt file
		while(in.hasNextLine()) {
			
			codes = in.nextLine(); 
		}
		// convert it to english
		return convertToEnglish(codes); 
	}
	
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them.
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree() 
	{
		String data="";
		ArrayList<String>list=new ArrayList<String>();
		list=tree.toArrayList();
		for(int i=0;i<list.size();i++) {
			data+=list.get(i)+ " ";
		}
		data = data.trim();
		return data;
	}

}
