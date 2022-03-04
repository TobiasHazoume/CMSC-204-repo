import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<T> implements StackInterface<T> {

	private final T[] stack;
	private int topIndex; // Index of top entry
	private static int stackSize = 25;
	private final int MAX_CAPACITY = 500;

	/**
	 * Creates an empty bag having a given initial capacity.
	 * 
	 * @param desiredCapacity The integer capacity desired.
	 */
	public MyStack(int desiredCapacity) {
		stack = (T[]) new Object[desiredCapacity];
		topIndex = -1;
	} // end constructor

	public MyStack() {
		this(stackSize);
	}

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return True if this bag is empty, or false if not.
	 */
	@Override
	public boolean isEmpty() {

		return topIndex == -1;
	}

	@Override
	public boolean isFull() {

		if (topIndex >= stack.length - 1) {

			return true; // array is full
		} else {
			return false;
		}
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * 
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		} else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * 
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		} else {
			return stack[topIndex];
		}
	}

	/**
	 * Number of elements in the Stack
	 * 
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return topIndex + 1;
	}

	/**
	 * Adds an element to the top of the Stack
	 * 
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(Object e) throws StackOverflowException {

		try {
			stack[topIndex + 1] = (T) e;
			topIndex++;
		} catch (ArrayIndexOutOfBoundsException d) {
			throw new StackOverflowException();
		}

		return true;
	}

	/**
	 * Returns the string representation of the elements in the Stack, the beginning
	 * of the string is the bottom of the stack Place the delimiter between all
	 * elements of the Stack
	 * 
	 * @return string representation of the Stack from bottom to top with elements
	 *         separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String stackText = null;

		for (int i = 0; i < stack.length; i++) {
			stackText = (String) stack[i] + delimiter;
		}

		return stackText;
	}

	/**
	 * Fills the Stack with the elements of the ArrayList, First element in the
	 * ArrayList is the first bottom element of the Stack YOU MUST MAKE A COPY OF
	 * LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the list reference
	 * within your Stack, you will be allowing direct access to the data of your
	 * Stack causing a possible security breech.
	 * 
	 * @param list elements to be added to the Stack from bottom to top
	 * @throws StackOverflowException if stack gets full
	 */
	@Override
	// should i replace it with public void fill(ArrayList<T> list) throws
	// StackOverflowException
	public void fill(ArrayList list) throws StackOverflowException {
		ArrayList newList = new ArrayList(list);

		if (size() + newList.size() > stack.length) {
			throw new StackOverflowException();
		}

		for (Object item : newList) {
			push((T) item);
		}

	}

}
