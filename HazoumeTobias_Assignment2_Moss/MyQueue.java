
/**
 * @author tobias
 *
 */
import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	private T[] queue;
	private int back;
	private int front;
	private int backIndex;
	private int frontIndex;
	private int size;
	public final static int QUEUE_SIZE = 25;

	// 1. takes an int as the size of the queue
	@SuppressWarnings("unchecked")
	public MyQueue(int desiredCapacity) {
		queue = (T[]) new Object[desiredCapacity];
		back = -1;
		front = 0;
		size = 0;
	}

	// default constructor - uses a default as the size
	// of the queue
	public MyQueue() {
		this(QUEUE_SIZE);

	}

	/**
	 * Determines if Queue is empty
	 * 
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Determines of the Queue is Full
	 * 
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		return size >= queue.length;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * 
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			T front = (T) queue[frontIndex]; // this is the current front element we'll delete
			queue[frontIndex] = null; // delete it
			frontIndex++; // reposistion the front pointer
			// front = queue[frontIndex]; // this is the new front value
			--size;
			return front;
		}
	}

	/**
	 * Returns number of elements in the Queue
	 * 
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Adds an element to the end of the Queue
	 * 
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean enqueue(T entry) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException("it's Full");
		} else {
			size++; // inc the size of the queue
			queue[backIndex++] = (T) entry;
			return true;
		}
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning
	 * of the string is the front of the queue
	 * 
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String queueText = "";
		for (int i = frontIndex; i < backIndex; i++) {
			queueText += queue[i];
		}

		return queueText;

	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning
	 * of the string is the front of the queue Place the delimiter between all
	 * elements of the Queue
	 * 
	 * @return string representation of the Queue with elements separated with the
	 *         delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String queueText = "";
		for (int i = frontIndex; i < backIndex; i++) {
			if (i == backIndex - 1) {
				queueText += queue[i];
			} else {
				queueText += queue[i] + delimiter;
			}
		}

		return queueText;
	}

	/**
	 * Fills the Queue with the elements of the ArrayList, First element in the
	 * ArrayList is the first element in the Queue YOU MUST MAKE A COPY OF LIST AND
	 * ADD THOSE ELEMENTS TO THE QUEUE, if you use the list reference within your
	 * Queue, you will be allowing direct access to the data of your Queue causing a
	 * possible security breech.
	 * 
	 * @param list elements to be added to the Queue
	 * @throws QueueOverflowException if queue is full
	 * 
	 */
	@Override
	public void fill(ArrayList list) {
		ArrayList newList = new ArrayList(list);
		
		if(size + newList.size() >queue.length) 
		{
			throw new QueueOverflowException();
		}
		
		for(Object item: newList) 
		{
			enqueue((T) item);
		}

	}

}
