import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author tobias Represents a town as a node of a graph. the these nodes will
 *         store town names. t
 *
 */
public class Town implements Comparable<Town> {
	private String townName; // town names
	protected List<Town> adjTowns = new ArrayList<>(); 	//to store adjtowns in a list
	protected int distanceOfRoad; // distance of road which is needed for dikstras
	protected List<List<Road>> roads = new ArrayList<>(); // adj matrix that stores roads instead of 1's and 0's
	private Town parent; //parent node that gets used in dikstras
	
	
	
	public void setAdjTowns(List<Town> townList) {
		adjTowns = townList;
	}

	
	public void setParent(Town tempParent) {
		parent = tempParent;
	}
	
	public Town getParent() {
		return parent;
	}

	public int getDistance() {
		return distanceOfRoad;
	}
	
	public void setDistance(int distance) {
		distanceOfRoad = distance;
	}

	public List<Town> getAdjTowns() {
		return adjTowns;
	}

	/**
	 * Constructor. Requires town's name.
	 * 
	 * @param name
	 */
	public Town(String name) {
		townName = name;
		roads = null;
	}

	/**
	 * Copy constructor. i think this is for making deep copies of a node 
	 * but is never used in the project
	 * 
	 * @param templateTown
	 */
	public Town(Town templateTown) {
		townName = templateTown.getName();
		roads = templateTown.roads;
		// for loop for store
	}

	/**
	 * Compare to method
	 * 
	 * @return - 0 if names are equal, a positive or negative number if the names
	 *         are not equal
	 */
	@Override
	public int compareTo(Town o) {
		// just to compare town names wont be used in diksras
		// so the townname of and object will be compared to the name of obj o
		//thi is different from a comparator
		return townName.compareTo(o.getName());

	}

	/**
	 * whats the point of this???
	 * 
	 * @return - true if the town names are equal, false if not
	 */
	public boolean equals(Object o) { // from slide 18 is also in the java text book
		boolean result;
		//check to see if town and o are not of the same class
		if ((o == null) || getClass() != o.getClass())
			return false;
		else {
			//sets other town to o since thier of the same class
			Town otherTown = (Town) o;
			result = townName.equals(otherTown.townName);
		}
		return result; //returns other towns name
	}

	/**
	 * Returns the town's name
	 * 
	 * @return - town's name
	 */
	public String getName() {
		return townName;
	}

	/**
	 * @return - the hashcode for the name of the town
	 */
	public int hashCode() {
		return townName.hashCode();
	}

	/**
	 * To string method. is never used by the project
	 * 
	 * @return - the town name and what nodes its adj to
	 */
	public String toString() {
		
		String string = townName+" ";

		for (Town town : adjTowns) {
			string+= town.townName +" ";
		}

		return string;
		
	}

	//test
// public static void main(String[] args) {
// Town town= new Town("name");
// System.out.println(town.getClass().getName());
// 
//}
 
 
}
