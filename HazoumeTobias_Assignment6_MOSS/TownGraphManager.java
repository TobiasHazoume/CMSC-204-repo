import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// There are methods to populate the graph (reading from a text file), 
// add a town (vertices), 
//add a road (edge), list all towns and all roads, and list towns adjacent to a given town.   

/**
 * @author tobias
 * 
 *         so it looks like this is what to user will be intereating with kinda
 *         like a level editor they get to draw thoier own towns and edges on
 *         the the graph so it looks like i can work on this class last
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {

	protected Town town;
	protected Road road;

	protected Graph graph = new Graph();

	/**
	 * Adds a road with 2 towns and a road name
	 * 
	 * @param town1    name of town 1 (lastname, firstname)
	 * @param town2    name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {

		// youre passing in towns and the class has a string in its contructor which
		// lets us do this

		if (graph.addEdge(new Town(town1), new Town(town2), weight, roadName) == null) {
			return false;
		}
		return true;

		// find town 1 in the matrix row and town 2 in the collum

		// place a new road in there with a weight and name
		// do the same for town 2 in the matrix row and town 1 in the collum

	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * 
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null
	 *         if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
		Road road = graph.getEdge(new Town(town1), new Town(town2));
		// if they dont have a road to eachother
		if (road == null) {
			return null;
		}
		return road.roadName;
	}

	/**
	 * Adds a town to the graph
	 * 
	 * @param v the town's name (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	/**
	 * Gets a town with a given name
	 * 
	 * @param name the town's name
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		Town town = new Town(name);
		// if the graph comtain a town give it the town
		if (graph.containsVertex(town)) {
			return town;
		}
		return null;
	}

	/**
	 * Determines if a town is already in the graph
	 * 
	 * @param v the town's name
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		return graph.containsVertex(new Town(v));
	}

	/**
	 * Determines if a road is in the graph
	 * 
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));
	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * 
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<Road> tempList = new ArrayList<>(graph.edgeSet());

		// road are soted
		Collections.sort(tempList);
		// takes the temp field and add the name field in the sorted names
		ArrayList<String> sortedNames = new ArrayList<>();
		for (Road road : tempList) {
			sortedNames.add(road.getName());
		}

		return sortedNames;
	}

	/**
	 * Deletes a road from the graph
	 * 
	 * @param town1    name of town 1 (lastname, firstname)
	 * @param town2    name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// make a raod obj based on the town

		Road theRoad = graph.getEdge(new Town(town1), new Town(town2));

		// check if the string doesnt match theRoad
		if (!(road.equals(theRoad.roadName))) {
			return false;
		}

		/// we know the names and road match up for letes remove the connection

		// creat a new town obj
		// checks the weight and town names
		if (graph.removeEdge(new Town(town1), new Town(town2), theRoad.weight, theRoad.roadName) == null) {
			return false;
		}

		return true;
	}

	/**
	 * Deletes a town from the graph
	 * 
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town(v));
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first
	 * name)
	 * 
	 * @return an arraylist of all towns in alphabetical order (last name, first
	 *         name)
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<Town> tempList = new ArrayList<>(graph.vertexSet());

		// town are soted
		Collections.sort(tempList);
		// takes the temp field and add the name field in the sorted names
		ArrayList<String> sortedNames = new ArrayList<>();
		for (Town town : tempList) {
			sortedNames.add(town.getName());
		}

		return sortedNames;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * 
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 *         towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// calls the shortest path method
		// pass in two towns
		return graph.shortestPath(new Town(town1), new Town(town2));

	}

	public void populateTownGraph(File selectedFile) throws FileNotFoundException {
		Scanner file = new Scanner(selectedFile);
		while (file.hasNextLine()) {
			String[] readLine = file.nextLine().split("[,;]");
			graph.addVertex(new Town(readLine[2]));
			graph.addVertex(new Town(readLine[3]));
			graph.addEdge(new Town(readLine[2]), new Town(readLine[3]), Integer.parseInt(readLine[1]), readLine[0]);

		}
		file.close();

	}
}
