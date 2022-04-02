import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * @author tobias
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface{
	
	protected int HashSize=0;
	protected int elementSize=0;
	private LinkedList<CourseDBElement> [] hashTable; 
	
	/**
	 * constructor takes in the size of the hash table
	 * @param size of hash table
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int size) {
		HashSize = fourKPlus3(size, 1.5);
		hashTable=new LinkedList[HashSize];
	}
	
	/**
	 * constructor used for testing purposes
	 * @param testing string
	 * @param size of the hash Table
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String testing,int size) {
		HashSize=size;
		hashTable=new LinkedList[HashSize];
	}
	
	/**
	* Use the hashcode of the CourseDBElement to see if it is 
	* in the hashtable. If the CourseDBElement does not exist in the hashtable,
	* add it to the hashtable.
	* 
	* @param element the CDE to be added 
	 */
	@Override
	public void add(CourseDBElement element) {

		int code;
		code=Math.abs(element.hashCode())% HashSize; //make values nonnegative	
		LinkedList <CourseDBElement>current=hashTable[code];
		if(element.ID.contains("-updated")) {
			System.out.println("hi");
			hashTable[code]=new LinkedList<CourseDBElement>();
			hashTable[code].add(element);
			elementSize++;
		}
		if(current==null) {
			hashTable[code]=new LinkedList<CourseDBElement>();
			hashTable[code].add(element);
			elementSize++;
		}
	}
		

	
	/**
	 * @param num
	 * @param loadfactor
	 * @return prime number
	 */
	public static int fourKPlus3(int num, double loadfactor) { 
		  boolean fkp3 = false;
		  boolean aPrime = false;
		  int prime, highDivisor, d;
		 

		   prime = (int)(num/loadfactor);
		   if(prime % 2 == 0) { 
		      prime = prime +1;
		   }
		   
		   while(fkp3 == false) 
		   {  while(aPrime == false) 
		      {  highDivisor = (int)(Math.sqrt(prime) + 0.5);
		         for(d = highDivisor; d > 1; d--)
		         {  if(prime % d == 0)
		               break; 
		         }
		         if(d != 1) 
		            prime = prime + 2;
		         else
		            aPrime = true;
		      }
		      if((prime - 3) % 4 == 0)
		         fkp3 = true;
		      else
		      {  prime = prime + 2;
		         aPrime = false;
		      }
		   } 
		   return prime;
		}
	
	/**
	 * Use the hashcode of the CourseDBElement to see if it is 
	 * in the hashtable. If the CourseDBElement is in the hashtable, return it
	 * If not, throw an IOException
	 * @return  course with the passed crn
	 * @throws IOException thrown when course not found
	 */

	@Override
	public CourseDBElement get(int crn) throws IOException {
		String crn1=Integer.toString(crn);
		int code=Math.abs(crn1.hashCode())% HashSize;
		if(hashTable[code]==null) {
			throw new IOException();
		}
		else{
			return (CourseDBElement) hashTable[code].get(0);
		}

	}
	
	
	/**
	 *
	 *@return hash size
	 */
	@Override
	public int getTableSize() {
		return HashSize;
	}
	
	/**
	 * Prints all courses in as a string 
	 * @return list of courses
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> courses=new ArrayList<String>();
		for(int i=0;i<HashSize;i++) {
			while(hashTable[i]!=null) {
				for(int j=0;j<hashTable[i].size();j++) {
					CourseDBElement element= (CourseDBElement) hashTable[i].get(j);
					courses.add("\n"+element.toString());
				}
				break;
			}
		}
		return courses;
	}
}