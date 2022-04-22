
/**
 * @author Tobias
 *
 * @param <T>
 */
public class TreeNode<T> {
	private T data;
	protected TreeNode<T> leftChild; // Reference to left child
	protected TreeNode<T> rightChild; // Reference to right child


	/**
	 * 
	 * Create a new TreeNode with left and right child set to null and data set to
	 * the dataNode
	 * 
	 * @param dataNode the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		data=dataNode;
		leftChild=null;
		rightChild=null;
	} // end default constructor



	/**
	 * constructor used for making deep copies
	 * 
	 * @param node - node to make a copy of
	 */
	public TreeNode(TreeNode<T> node) {
		//this code below messed me up alot
		//this() refers to the current object in a method or constructor
		//plus i wasnt assigning any values to the variables
		//this(node.getData(),node.leftChild,node.rightChild);
		
		leftChild = node.leftChild;
		rightChild= node.rightChild;
		data = node.getData();
	}

	/**
	 * Return the data within this TreeNode
	 * 
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return data;
	} // end getData
	
	//R and leftChild are protected so they dont need getters
}
