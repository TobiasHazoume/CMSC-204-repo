import java.util.Comparator;
import java.util.ListIterator;

//import BasicDoubleLinkedList.Node;

//import BasicDoubleLinkedList.Node;

/**
 * @author tobias
 *
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {


	private Comparator<T> compareableObject;

	/**
	 * define an attribute of type Comparator and use it to compare the data in the list
	 * @param compareableObject define an attribute of type Comparator and use it to compare the data in the list
	 */
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		super();
		this.compareableObject = compareableObject;

	}


	/**
	 * The addToFront and the addToEnd methods inherited
	 *  from the BasicDoubleLinkedList will not be supported
	 */
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * The addToFront and the addToEnd methods inherited
	 *  from the BasicDoubleLinkedList will not be supported
	 */
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	// 
	/**
	 *Implements the iterator by calling the super class iterator method.
	 */
	public ListIterator<T> iterator() {
		return (ListIterator<T>) super.iterator();
	}



	
	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * Notice we can insert the same element several times.
	 * Your implementation must traverse the list only once in order to perform the
	 * insertion.
	 * 
	 * @param data
	 */
	public void add(T data) 
	{
		 
		 if (data == null) {
		      return;
		    }

		    Node<T> presentNode = new Node<T>(data);
		    //if its empty
		    if (head == null) {
		     
		      head = tail = new Node<T>(data);
		    } else {
		      // if data need to go right at the head since its smaller
		      if (compareableObject.compare(data, head.data) <= 0) {
		        presentNode.next = head;
		        head = presentNode;
		      }
		      //if data need to go to the right of tail since its bigger
		      else if (compareableObject.compare(data, tail.data) >= 0) {
		        tail.next = presentNode;
		        tail = presentNode;
		      } else {
		        //if data needs to go in the middle of the LL
		        Node<T> next = head.next;
		        Node<T> prev = head;
		        while (compareableObject.compare(data, next.data) > 0) {
		          prev = next;
		          next = next.next;
		        }
		        // insert the element
		        prev.next = presentNode;
		        presentNode.next = next;
		      }
		    }
		    size++;
		 }
//	public BasicDoubleLinkedList<T>.Node<T>remove(T data, Comparator<T> comparator)
//	{
//		return super.remove(data, comparator);
//	}
	
}
