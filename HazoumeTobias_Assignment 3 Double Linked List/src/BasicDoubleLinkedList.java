import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author tobias
 *
 */
public class BasicDoubleLinkedList<T> implements Iterable // implements the Java’s Iterable interface
<T>
{
	//should i change these back to private????
	protected int size = 0;
	protected Node<T> head = null;
	protected Node<T> tail = null;

	// Both the head and the tail are set to null when the list is empty
	/**
	 * Constructor to initialize the current pointer to the head of the BasicDoubleLinkedList.
	 *  The other attributes defined for this class can be initialized as well.
	 */
	BasicDoubleLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	// 
	/**
	 * generic inner class Node
	 *
	 */
	@SuppressWarnings("hiding")
	protected class Node<T> {
		// All the entities are defined as protected so they can be accessed by the
		// subclass.
		protected T data;
		protected Node<T> next;
		protected Node<T> prev;

		/**
		 *  const that passes just data to our node
		 * @param data
		 */
		public Node(T data) {
			this.data = data;
		}

		
		/**
		 * const that passes these values to our node
		 * 
		 * @param data
		 * @param next
		 * @param prev
		 */
		public Node(T data, Node<T> next, Node<T> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		/**
		 * @return data
		 */
		public T getData() {
			return data;
		}

//
//		public void setData(T data) {
//			this.data = data;
//		}
//
		/**
		 *  get next
		 */
		public Node<T> getNext() {
			return next;
		}


		/**
		 *  set next
		 */
		public void setNext(Node<T> next) {
			this.next = next;
		}

		/**
		 *  set prev
		 */
		public Node<T> getPrev() {
			return prev;
		}
//
//		public void setprev(Node prev) {
//			this.prev = prev;
//		}

	}// end of node



	/**
	 * Adds element to the end of the list and updated the size of the list
	 * @param data - node data
	 */
	public void addToEnd(T data) {

		Node<T> tempNode = new Node<T>(data);

		if (size == 0) {
			head = tail = tempNode;

		} else {
			tail.next = tempNode;
			tempNode.prev = tail;
			tail = tempNode;
		}

		size++;
	}


    /**
     *  Adds element to the front of the list and updated the size of the list
	 * @param data - node data
	 */
	public void addToFront(T data) {

		Node<T> tempNode = new Node<T>(data);

		if (size == 0) {
			head = tail = tempNode;
		} else {
			head.prev = tempNode;
			tempNode.next = head;
			head = tempNode;
		}

		size++;
	}


    /**
     *  Returns but does not remove the first element from the list.
     * @return head data
     */
	public T getFirst() {
		// If there are no elements the method returns null.
		if (head == null) {
			return null;
		}
		return (T) head.data; // this in the data in the first node or should it be just head?
	}

    /**
     *  get the last
     * @return tail data
     */
	public T getLast() {
		// If there are no elements the method returns null.
		if (head == null) {
			return null;
		}

		return (T) tail.data; // same as getFirst()
	}

 
    /**
     *  get the # of nodes
     * @return size
     */
	public int getSize() {
		return size;
	}

    /**
     *  This method returns an object of the DoubleLinkedListIterator.
     * @return DoubleLinkedListIterator
     */
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator<T>();
	}



    /**
     * Removes the first instance of the targetData from the list.
     * @param targetData  the data element to be removed 
     * @param comparator  the comparator to determine equality of data elements
     * @return a node containing the targetData or null
     */
    public Node<T> remove(T targetData, Comparator<T> comparator) 
    {
        Node<T> presentNode = head;
        if (size == 1 && comparator.compare(targetData, presentNode.getData()) == 0) {
            head = tail = null;
            size--;
            return presentNode;
        }
        while (presentNode != null) {
            if (presentNode == head && comparator.compare(targetData, presentNode.getData()) == 0) {
                head = presentNode.next;
                presentNode.next.prev = null;
                presentNode.next = null;
                size--;
                break;
            } else if (presentNode == tail && comparator.compare(targetData, presentNode.getData()) == 0) {
                tail = presentNode.prev;
                presentNode.prev.next = null;
                presentNode.next = null;
                size--;
                break;
            } else if (comparator.compare(targetData, presentNode.getData()) == 0) {
                presentNode.prev.next = presentNode.next;
                presentNode.next.prev = presentNode.prev;
                presentNode.next = null;
                presentNode.prev = null;
                size--;
                break;
            }
            presentNode = presentNode.next;
        }
        return presentNode;
    }
		
		 	 




    /**
     *  A generic inner class named DoubleLinkedListIterator
     * that implements java’s ListIterator interface (for the iterator method).
     */
    protected class DoubleLinkedListIterator<U> implements ListIterator<T> { // iterator class
        protected Node<T> node;
        private int index = 0;

        public DoubleLinkedListIterator() { // creates the iterator

            node = null;
            index = 0;
        }

        /**
         *  move to the next node in the list
         * @throws value
         */
        public T next() {
            if (hasNext())
            {
                T value;
                if (index==0)
                {
                    node=head;
                }
                value =node.getData();
                node=node.next;
                index++;

                return value;
            }
            throw new NoSuchElementException();
        }

        
        /**
         *  see if theres a node in front of this node
         * @throws boolean
         */
        @Override
        public boolean hasNext() { // checks if there is more data
            if(index==size)
            {
                return false;
            }
            return true;
        }

        
        /**
         *  go back a node in the list
         * @throws NoSuchElementException
         */
        @Override
        public T previous() { // goes back
            if (hasPrevious())
            {
                T datam;
                if(index==size)
                {
                    node=tail;
                }
                datam =node.getData();
                node=node.prev;
                index--;
                return datam;
            }
            throw new NoSuchElementException();
        }


        /**
         *  see if theres a node behind this node
         * @return boolean
         */
        @Override
        public boolean hasPrevious() {
            if(index == 0)
            {
                return false;
            }
            return true;
        }
        

        /**
         *  get 1st element and remove it
         * @return returnValue
         */
        public T retrieveFirstElement() {
    		
    		if(head == null) {
    			return null;
    		}
    		
    		
    			Node<T> tempNode = head;
    			T returnValue = tempNode.data; //get the data
    			head = head.next;
    			tempNode.next = null; //remove the data
    			size--; //decrease the LL size  			
    			return returnValue;
    	}
        
        
        //
    	/**
    	 *  get last element and remove it
    	 * @return returnValue
    	 */
    	public T retrieveLastElement() { 
    		if(head == null) {
    			
    			return null;
    		}
    		
    			Node<T> tempNode = tail;
    			T returnValue = tempNode.data;
    			tail = head.next;
    			tempNode.next = null;
    			size--;
    			return returnValue; 	
    	}


    	/**
    	 *  adds data to an array list
    	 * @return array
    	 */
    	public ArrayList<T> toArrayList() {
    		
    		ArrayList <T> array = new ArrayList <T>();
    		BasicDoubleLinkedList<T>.Node<T> node = head;
    		
    		while(node != null) { 
    			
    			array.add(node.data);
    			
    			node = node.next;
    		}
    	
    		return array;
    		
    	}
	// The rest of the methods should throw the UnsupportedOperationException
	/**
	 *  add in interface
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void add(Object e) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 *  add nextIndex in interface
	 * @throws UnsupportedOperationException
	 */
	@Override
	public int nextIndex() throws UnsupportedOperationException {

		throw new UnsupportedOperationException();
	}

	/**
	 *  add previousIndex
	 * @throws UnsupportedOperationException
	 */
	@Override
	public int previousIndex() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 *  remove
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 *  add set method
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void set(Object e) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	
	/**
	 *  This method returns an object of the DoubleLinkedListIterator
	 * @return DoubleLinkedListIterator
	 */
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new DoubleLinkedListIterator<T>();
	}

}

}
