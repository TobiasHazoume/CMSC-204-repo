
/**
 * @author tobias
 *
 */
public class CourseDBElement implements Comparable{
	
	/*
	 * the Course ID (a String), the CRN (an int), 
	 * the number of credits (an int), t
	 * he room number (a String), and 
	 * the instructor name (a String
	 * */
	protected String ID;
	protected int crn;
	protected int credits;
	protected String room;
	protected String instructorName;
	

	/**
	 * Default constructor
	 */
	public CourseDBElement() {
		this(null,00000,0,null,null);
	}
	
	/**
	 * constructor to assign values to fields
	 * @param id course ID
	 * @param crn Course number
	 * @param credits number of credits
	 * @param roomNum classroom for the course
	 * @param instructor name of instructor for course
	 */
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		ID=id;
		this.crn=crn;
		this.credits=credits;
		room=roomNum;
		instructorName=instructor;
	}
	/**
	 * sets value to crn field
	 * @param crn value to assign to crn field
	 */
	public void setCRN(int crn) {
		this.crn=crn;
	}
	
	/**
	 *returns value of crn 
	 * @return crn
	 */
	public int getCRN() {
		return crn;
	}
	
	/**
	 *returns value of id 
	 * @return id
	 */
	public Object getID() {
		return ID;
	}



	/**
	 * @return value of room
	 */
	public Object getRoomNum() {
		return room;
	}
	
	/**
	 * compares crn of 2 courses
	 * returns -1 if the crn of element is smaller,
	 *  1 if the crn of element is greater 
	 *  and 0 if theyre the same
	 * @param element course to be compared
	 * @return number
	 */
	public int compareTo(CourseDBElement element) {
		if(element.crn==crn) {
			return 0;
		}
		else if(element.crn<crn) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	/**
	 * parse crn into string then return it's hashcode
	 * @return hashcode of crn
	 */
	public int hashCode() {
		String crn1=Integer.toString(crn);
		return crn1.hashCode();
	}
	
	/**
	 * @return string format of course
	 */
	public String toString() {
		String course="Course:"+ID+" "
				+ "CRN:"+crn
				+" Credits:"+credits
				+" Instructor:"+instructorName
				+" Room:"+room;
		return course;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}









}
