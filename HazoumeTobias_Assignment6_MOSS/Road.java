
/**
 * @author tobias
 *
 */
public class Road implements Comparable<Road> {

	protected Town sourceVertex; // the vertex at the start of an edge
	protected Town destinationVertex; // the vertex at the end of an edge
	protected int weight; // the weight of an edge
	protected String roadName; // the weight of an edge

	/**
	 * Constructor
	 * 
	 * @param source      - One town on the road
	 * @param destination - Another town on the road
	 * @param degrees     - Weight of the edge, i.e., distance from one town to the
	 *                    other
	 * @param name        - Name of the road
	 */
	public Road(Town source, Town destination, int degrees, String name) {

		sourceVertex = source;
		destinationVertex = destination;
		weight = degrees;
		roadName = name;
	}

	/**
	 * Constructor with weight preset at 1
	 * 
	 * @param source      - One town on the road
	 * @param destination - Another town on the road
	 * @param name        - Name of the road
	 */
	public Road(Town source, Town destination, String name) {
		weight = 1;
		sourceVertex = source;
		destinationVertex = destination;
		roadName = name;
	}

	/**
	 * Returns true only if the edge contains the given town
	 * 
	 * @param town - a vertex of the graph
	 * @return - true only if the edge is connected to the given vertex
	 */
	public boolean contains(Town town) {
		// see if the a town  has either the same source or 
		//destination	 vertex		
		return ( town.getName().equals(sourceVertex.getName()) ) || ( town.getName().equals(destinationVertex.getName()) );
	}

	/**
	 * this isnt worded right!!!!!
	 * tostring method
	 */ 
	public String toString() {
		String result = "name " + getName() + " destination Vertex " + getDestination() + " Source Vertex "
				+ getSource() + " Weight " + getWeight();

		return result;

	}

	/**
	 * return the road name
	 * 
	 * @return - return the road name
	 */
	public String getName() {
		return roadName;

	}

	/**
	 * Returns the second town on the road
	 * 
	 * @return - A town on the road
	 */
	public Town getDestination() {
		return destinationVertex;

	}

	/**
	 * Returns the first town on the road
	 * 
	 * @return -Returns the first town on the road
	 */
	public Town getSource() {
		return sourceVertex;

	}

	/**
	 * @reurn 0 if the road names are the same, a positive or negative number if the
	 *        road names are not the same
	 *
	 */
	@Override
	public int compareTo(Road o) {
		
		return roadName.compareTo(o.getName());
	}

	/**
	 * @return Returns the distance of the road
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Returns true if each of the ends of the road r is the same as the ends of
	 * this road. Remember that a road that goes from point A to point B is the same
	 * as a road that goes from point B to point A.
	 * 
	 * @param r - road object to compare it to
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean equals(Object r) {



		// return if  the starting vertex has the same name as r's  starting vertex OR a desination vertex. 
		// do the same for the desination vertex
		return ( sourceVertex.getName().equals(((Road) r).getSource().getName()) ||
				sourceVertex.getName().equals(((Road) r).getDestination().getName()) ) &&
						( destinationVertex.getName().equals(((Road) r).getSource().getName()) || 
						destinationVertex.getName().equals(((Road) r).getDestination().getName()) );


	}

}
