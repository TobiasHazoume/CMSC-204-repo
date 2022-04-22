import java.util.ArrayList;

/**
 * @author Tobias
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {// why string?

	private TreeNode<String> root;

	/**
	 * this is what were passing to the class my default when we use it and it will
	 * call the build tree method to make the tree
	 */
	public MorseCodeTree() {
		// root = null;
		root = new TreeNode<String>("");
		buildTree();
	} // end default constructor

	/**
	 * Returns a reference to the root
	 * 
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		// returns the root of the tree
		return root;

	}

	/**
	 * sets the root of the Tree
	 * 
	 * @param newNode a TreeNode that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<String>(newNode);

	}

	/**
	 * Adds result to the correct position in the tree based on the code This method
	 * will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * 
	 */
	@Override
	public void insert(String code, String result) {
		// TODO Auto-generated method stub
		addNode(root, code, result); // this is the only thing thats needed tbh

	}

	/**
	 * This is a recursive method that adds element to the correct position in the
	 * tree based on the code.
	 * 
	 * @param root   the root of the tree for this particular recursive instance of
	 *               addNode
	 * @param code   the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
	//this is the method that will place nodes where they need to go in the tree
		
		if (code.length() == 1) {

			if (code.charAt(0) == '.') {
				//makes the root the node a leftChild with the specific letter
				root.leftChild = new TreeNode<String>(letter); 
			} else if (code.charAt(0) == '-') {

				root.rightChild = new TreeNode<String>(letter); 
			}

			//if the code is are than 1 char
		} else {

			if (code.charAt(0) == '.') {
				//calls the method again to
				//makes node be the left child in the tree then
				// shortens the code by the first char then 
				//asign a letter to it
				addNode(root.leftChild, code.substring(1), letter); 
			}

			else if (code.charAt(0) == '-') {		
				//calls the method again to
				//makes node be the right child in the tree then
				// shortens the code by the first char then 
				//asign a letter to it
				addNode(root.rightChild, code.substring(1), letter);
			}

		}

	}

	/**
	 * Fetch the data in the tree based on the code This method will call the
	 * recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		// call the recursive method fetchNode and store it in result
		String result = fetchNode(root, code);
		return result;
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that
	 * corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of
	 *             addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		// not sure if this is needed
		if (code.length() == 0) {
			return root.getData(); // get the roots data
		} else if (code.length() > 1) {
			if (code.charAt(0) == '.') {
				// call the fetch node but set root as
				// the original roots left child and
				// shorten the code by the first char
				return fetchNode(root.leftChild, code.substring(1));

				// if code.charAt(0) == '- '
			} else {
				return fetchNode(root.rightChild, code.substring(1));
			}
			// if code.length() <= 1
		} else {
			if (code.equals(".")) {
				return root.leftChild.getData();
			} else {
				return root.rightChild.getData();
			}
		}
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * 
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException - we're not using this so we're throwing an exception
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// we're not using this so we're throwing an exception
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * 
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException - we're not using this so we're throwing an exception
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// we're not using this so we're throwing an exception
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes into
	 * their proper locations
	 * 
	 */
	@Override
	public void buildTree() {
		//these are the values that will eventually get passed to the
		//addnode method to create a proper tree
		
		// root level 0
		setRoot(new TreeNode<String>(""));
		// level 1
		insert(".", "e");
		insert("-", "t");
		
		// level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		// level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		// level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");

	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR
	 * (Inorder) Traversal order Used for testing to make sure tree is built
	 * correctly
	 * 
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(root, list);
		return list;
	}

	/**
	 * The recursive method to put the contents of the linked converter tree in an
	 * ArrayList LNR (Inorder)
	 * 
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR
	 *             order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if (root.leftChild != null) {
			LNRoutputTraversal(root.leftChild, list);

		}
		list.add(root.getData());

		if (root.rightChild != null) {
			LNRoutputTraversal(root.rightChild, list);

		}

	}

}
