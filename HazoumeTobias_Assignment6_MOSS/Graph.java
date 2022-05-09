import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * The root interface in the graph hierarchy. A mathematical graph-theory graph
 * object G(V,E) contains a set V of vertices and a set E of edges. Each edge
 * e=(v1,v2) in E connects vertex v1 to vertex v2.
 *
 * Through generics, a graph can be typed to specific classes for vertices V and
 * edges E<T>. Such a graph can contain vertices of type V and all sub-types and
 * Edges of type E and all sub-types.
 */
public class Graph implements GraphInterface<Town, Road> {
	Town vertex;
	Road edge;
	List<List<Road>> adjMatrix = new ArrayList<>();
	List<Town> townList = new ArrayList<>(); // this will help us traverse our matrix

	ArrayList<String> pathToPrint = new ArrayList<>(); // out put of the shortest path for Dikstras

	/**
	 * Constructor. adding this was my idea idk if i should do thiis
	 * 
	 * @param
	 */
	public Graph() {
		vertex = null;
		edge = null;

	}

	/**
	 * Returns an edge connecting source vertex to target vertex if such vertices
	 * and such edge exist in this graph. Otherwise returns null. If any of the
	 * specified vertices is null returns null
	 *
	 * In undirected graphs, the returned edge may have its source and target
	 * vertices in the opposite order.
	 *
	 * @param sourceVertex      source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 *
	 * @return an edge connecting source vertex to target vertex.
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		// check if we have values in our vertexs
		if (sourceVertex == null || destinationVertex == null) {
			// return the road they both have in common;
			return null;

		}
		if (!(townList.contains(sourceVertex) && townList.contains(destinationVertex))) {
			return null;
		}
		// return the road or road
		return adjMatrix.get(townList.indexOf(sourceVertex)).get(townList.indexOf(destinationVertex));

	}

	/**
	 * Creates a new edge in this graph, going from the source vertex to the target
	 * vertex, and returns the created edge.
	 * 
	 * The source and target vertices must already be contained in this graph. If
	 * they are not found in graph IllegalArgumentException is thrown.
	 *
	 *
	 * @param sourceVertex      source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 * @param weight            weight of the edge
	 * @param description       description for edge
	 *
	 * @return The newly created edge if added to the graph, otherwise null.
	 *
	 * @throws IllegalArgumentException if source or target vertices are not found
	 *                                  in the graph.
	 * @throws NullPointerException     if any of the specified vertices is null.
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		//check if the value of the edge we want to create is null
		if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();

		}

		if (weight <= 0) // negative nums dont work for dikstras
		{
			throw new IllegalArgumentException();
		}

		// check is the source and destination are in the graph
		if (!(townList.contains(sourceVertex) && townList.contains(destinationVertex))) {
			throw new IllegalArgumentException();
		}

		// check if they're the same
		if (sourceVertex.equals(destinationVertex)) {
			throw new IllegalArgumentException();
		}

		// make an edge obj which is named edge
		edge = new Road(sourceVertex, destinationVertex, weight, description);

		// add road to the matxrix
		// were using the townList to traverse the matrix since they both match
		adjMatrix.get(townList.indexOf(sourceVertex)).set(townList.indexOf(destinationVertex), edge);
		// add a road for vice versa
		adjMatrix.get(townList.indexOf(destinationVertex)).set(townList.indexOf(sourceVertex), edge);
		if (!(adjMatrix.get(townList.indexOf(sourceVertex)).get(townList.indexOf(destinationVertex)).equals(edge)
				|| adjMatrix.get(townList.indexOf(destinationVertex)).get(townList.indexOf(sourceVertex))
						.equals(edge))) {
			return null;
		}
		return edge;
	}

	/**
	 * Adds the specified vertex to this graph if not already present. More
	 * formally, adds the specified vertex, v, to this graph if this graph contains
	 * no vertex u such that u.equals(v). If this graph already contains such
	 * vertex, the call leaves this graph unchanged and returns false. In
	 * combination with the restriction on constructors, this ensures that graphs
	 * never contain duplicate vertices.
	 *
	 * @param v vertex to be added to this graph.
	 *
	 * @return true if this graph did not already contain the specified vertex.
	 *
	 * @throws NullPointerException if the specified vertex is null.
	 */
	@Override
	public boolean addVertex(Town v) throws NullPointerException {
		// check if this vertex is already in the graph
		if (townList.contains(v)) {
			return false;
		}
		if (v == null) {
			return false;
		}

		//add v to twon list
		townList.add(v);
		// add row to matrix
		adjMatrix.add(new ArrayList<Road>());
		for (int element = 0; element < townList.size() - 1; element++) {
			//adding collums to the matrix but doesnt make a the last collum for the row
			//-1 it is so our matrix doesnt have an extra element
			adjMatrix.get(adjMatrix.size() - 1).add(null);
		}
		//this create our last row by going through each row and adding a new element thats set to null
		for (List<Road> list : adjMatrix) {
			list.add(null);
		}

		return true;

	}

	/**
	 * Returns true if and only if this graph contains an edge going from the source
	 * vertex to the target vertex. In undirected graphs the same result is obtained
	 * when source and target are inverted. If any of the specified vertices does
	 * not exist in the graph, or if is null, returns false.
	 *
	 * @param sourceVertex      source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 *
	 * @return true if this graph contains the specified edge.
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {

		// check If the sourceVertex and destinationVertex are not in the graph
		if (!(townList.contains(sourceVertex) && townList.contains(destinationVertex))) { // come back to this condition
			return false;
		}

		// check if its null in the going from the source vertex to the target in the
		// matrix
		if (adjMatrix.get(townList.indexOf(sourceVertex)).get(townList.indexOf(destinationVertex)) == null) {
			return false;
		}

		// vice versa
		if (adjMatrix.get(townList.indexOf(destinationVertex)).get(townList.indexOf(sourceVertex)) == null) {
			return false;
		}

		return true;
	}

	/**
	 * Returns true if this graph contains the specified vertex. More formally,
	 * returns true if and only if this graph contains a vertex u such that
	 * u.equals(v). If the specified vertex is null returns false.
	 *
	 * @param v vertex whose presence in this graph is to be tested.
	 *
	 * @return true if this graph contains the specified vertex.
	 */
	@Override
	public boolean containsVertex(Town v) {
		// Returns a bool if this graph contains the specified vertex.
		if (townList.contains(v)) {
			return true;
		} else
			return false;

	}

	/**
	 * Returns a set of the edges contained in this graph. The set is backed by the
	 * graph, so changes to the graph are reflected in the set. If the graph is
	 * modified while an iteration over the set is in progress, the results of the
	 * iteration are undefined.
	 *
	 *
	 * @return a set of the edges contained in this graph.
	 */
	@Override
	public Set<Road> edgeSet() {
		// make tempset to store the set of edges we want to output
		Set<Road> tempRoadSet = new HashSet<Road>();

		// iterate through every row using 2 foreach loops 1 for row 1 for collum
		// when ever you get put in hash settt

		// loop thorugh the rows using townlist
		for (List<Road> row : adjMatrix) {
			// loop through collums im making a while loop instead
			for (Road element : row) {
				if (element != null) {
					tempRoadSet.add(element);
				}
			}

		}
		return tempRoadSet;
	}

	/**
	 * Returns a set of all edges touching the specified vertex (also referred to as
	 * adjacent vertices). If no edges are touching the specified vertex returns an
	 * empty set.
	 *
	 * @param vertex the vertex for which a set of touching edges is to be returned.
	 *
	 * @return a set of all edges touching the specified vertex.
	 *
	 * @throws IllegalArgumentException if vertex is not found in the graph.
	 * @throws NullPointerException     if vertex is null.
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {

		// if vertex is not found in the graph
		if (!(townList.contains(vertex))) {
			throw new IllegalArgumentException();
		}

		if (vertex == null) {
			throw new NullPointerException();
		}

		// grab from the row and place the edges in our set
		Set<Road> tempSet = new HashSet<>();
		// lets us access the town row
		int matrixInddex = townList.indexOf(vertex);
		// go thorugh each element in the row and whatevers not null will go in the set
		for (Road element : adjMatrix.get(matrixInddex)) {
			if (element != null) {
				tempSet.add(element);
			}
		}

		return tempSet;
	}

	/**
	 * Removes an edge going from source vertex to target vertex, if such vertices
	 * and such edge exist in this graph.
	 * 
	 * If weight >- 1 it must be checked If description != null, it must be checked
	 * 
	 * Returns the edge if removed or null otherwise.
	 *
	 * @param sourceVertex      source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 * @param weight            weight of the edge
	 * @param description       description of the edge
	 *
	 * @return The removed edge, or null if no edge removed.
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		// if such vertices and such edge exist in this graph.

		// If weight >- 1
		if (weight < 0) {
			return null;
		}

		// If description != null
		if (description == null) {
			return null;
		}

		//made this object to see if this was the road 
		//we wanted to remove when comparing it to the source and desintation verex
		Road roadToCompare = new Road(sourceVertex, destinationVertex, weight, description);

		//new want to traverse the matrix using 
		int sourceInx =townList.indexOf(sourceVertex);
		int destinationInx =townList.indexOf(destinationVertex);
		
		//checks if the proper road is there
		if(!(adjMatrix.get(sourceInx).get(destinationInx).equals(roadToCompare)) ||
				!(adjMatrix.get(destinationInx).get(sourceInx).equals(roadToCompare)) ) {
			return null;
		}
		
		//actually sets the proper road to null 
		adjMatrix.get(sourceInx).set(destinationInx,null);
		adjMatrix.get(destinationInx).set(sourceInx,null);

		return roadToCompare;
	}

	/**
	 * Removes the specified vertex from this graph including all its touching edges
	 * if present. More formally, if the graph contains a vertex u such that
	 * u.equals(v), the call removes all edges that touch u and then removes u
	 * itself. If no such u is found, the call leaves the graph unchanged. Returns
	 * true if the graph contained the specified vertex. (The graph will not contain
	 * the specified vertex once the call returns).
	 *
	 * If the specified vertex is null returns false.
	 *
	 * @param v vertex to be removed from this graph, if present.
	 *
	 * @return true if the graph contained the specified vertex; false otherwise.
	 */
	@Override
	public boolean removeVertex(Town v) {

		if (!townList.contains(v)) {
			return false;
		}

		if (v == null) {
			return false;
		}

		// get the location of v in our array to help us 
		//traverse the matrix to that specific spot
		int town = townList.indexOf(v); //so if the town was 3 then the index would be 3, this is different to .size()
		// go thorugh each row
		for (int row = 0; row < townList.size(); row++) {// removes the collum
			adjMatrix.get(row).remove(town);
		}
		adjMatrix.remove(town);// removes the entire row


		// remove the town from the townlist
		townList.remove(v);

		return true;
	}

	/**
	 * Returns a set of the vertices contained in this graph. The set is backed by
	 * the graph, so changes to the graph are reflected in the set. If the graph is
	 * modified while an iteration over the set is in progress, the results of the
	 * iteration are undefined.
	 *
	 *
	 * @return a set view of the vertices contained in this graph.
	 */
	@Override
	public Set<Town> vertexSet() {
		// returns the set of verts contain in our towns so wer're returing the towns
		return new HashSet<>(townList);

	}

	/**
	 * Find the shortest path from the sourceVertex to the destinationVertex call
	 * the dijkstraShortestPath with the sourceVertex
	 * 
	 * @param sourceVertex      starting vertex
	 * @param destinationVertex ending vertex
	 * @return An arraylist of Strings that describe the path from sourceVertex to
	 *         destinationVertex They will be in the format: startVertex "via" Edge
	 *         "to" endVertex weight As an example: if finding path from Vertex_1 to
	 *         Vertex_10, the ArrayList<String> would be in the following
	 *         format(this is a hypothetical solution): Vertex_1 via Edge_2 to
	 *         Vertex_3 4 (first string in ArrayList) Vertex_3 via Edge_5 to
	 *         Vertex_8 2 (second string in ArrayList) Vertex_8 via Edge_9 to
	 *         Vertex_10 2 (third string in ArrayList)
	 */
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		if (!(townList.contains(sourceVertex) || townList.contains(destinationVertex))) {
			throw new IllegalArgumentException();
		}
		dijkstraShortestPath(sourceVertex);

		//stores the destination town vertex and how we got the shortest path to it via text 
		Town presentTown = townList.get(townList.indexOf(destinationVertex));
		//while present town has a parent
		while (presentTown.getParent() != null) {
			String string = presentTown.getParent().getName() + " via "
					+ getEdge(presentTown, presentTown.getParent()).getName() + " to " + presentTown.getName() + " "
					+ getEdge(presentTown, presentTown.getParent()).getWeight() + " mi";
			pathToPrint.add(string);

			presentTown = presentTown.getParent();
		} //was the string in reverse order
		
		//if your destination is the same as your start
		if (!presentTown.equals(sourceVertex)) {
			pathToPrint.clear();
		}
		//resets all the we got from diksras distances to a -2billion for the next time we use the algo
		for (Town thistown : townList) {
			thistown.setDistance(Integer.MIN_VALUE);
		}
		
		if (pathToPrint.isEmpty()) {
			return new ArrayList<>();
		}
		Collections.reverse(pathToPrint); //put our string in the proper order 
		return pathToPrint;
	}

	/**
	 * Dijkstra's Shortest Path Method. Internal structures are built which hold the
	 * ability to retrieve the path, shortest distance from the sourceVertex to all
	 * the other vertices in the graph, etc.
	 *
	 * @param sourceVertex the vertex to find shortest path from
	 *
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		//set the distance of every town to  max value using a for each loop
		for (Town thisTown : townList) {
			thisTown.setDistance(Integer.MAX_VALUE);
			thisTown.setParent(null);
		}
		//set source vertex's distance to 0 insead of max value
		townList.get(townList.indexOf(sourceVertex)).setDistance(0);
		pathToPrint.clear(); //clears the shorest path text box in the gui

		
		// town size is the 1st parameter,uses a lambda as a 2nd parameter to compare the distance of two towns useing the comparator method 
		// which gets the difference between the two towns 
		Queue<Town> minHeap = new PriorityQueue<>(townList.size(),(Town thisTown, Town otherTown) -> 
		thisTown.distanceOfRoad - otherTown.distanceOfRoad);
		
		///takes the town list and puts it in the heap
		minHeap.addAll((townList));
		//while the queue is full empty all its elements
		while (!minHeap.isEmpty()) {
			Town thisTown = minHeap.remove(); // removes the minimun value in the heap but store it in thistown
			
			for (Town hood : getListOfAdjacentTowns(thisTown)) {
				if (minHeap.contains(hood)) {
					if (hood.getDistance() > thisTown.getDistance() + getEdge(thisTown, hood).getWeight()) {
						hood.setDistance(thisTown.getDistance() + getEdge(thisTown, hood).getWeight());
						hood.setParent(thisTown);
						//removes and adds hood to the p queue so its properly ordered
						minHeap.remove(hood);
						minHeap.add(hood);
					}
				}
			}
		}
	}

	//makes a arraylist that stores the towns a specific node is adjcent to
	public List<Town> getListOfAdjacentTowns(Town thisTown) {
		int row = townList.indexOf(thisTown);
		List<Town> list = new ArrayList<>();
		for (int element = 0; element < townList.size(); ++element) {
			if (adjMatrix.get(row).get(element) != null) {
				list.add(townList.get(element));
			}
		}
		thisTown.setAdjTowns(list);
		return list;
	}

}
