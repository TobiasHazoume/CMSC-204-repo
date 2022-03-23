import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedListTest_STUDENT {
	BasicDoubleLinkedList<Double> linkedDouble;
	DoubleComparator comparatorD;

	@Before
	public void setUp() throws Exception {
		

		linkedDouble = new BasicDoubleLinkedList<Double>();
		
		linkedDouble.addToEnd(30.0);
		linkedDouble.addToFront(24.0);
		linkedDouble.addToEnd(32.0);
		
		comparatorD = new DoubleComparator();
		
	}

	@After
	public void tearDown() throws Exception {
		linkedDouble = null;
		comparatorD = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(3,linkedDouble.getSize());
		
	}
	
	@Test
	public void testAddToEndSTUDENT(){
		assertEquals(Double.valueOf(32), linkedDouble.getLast());
		linkedDouble.addToEnd(20.0);
		assertEquals(Double.valueOf(20), linkedDouble.getLast());
	}

	@Test
	public void testAddToFrontSTUDENT(){
		assertEquals(Double.valueOf(24), linkedDouble.getFirst());
	}

	@Test
	public void testGetFirstSTUDENT(){
		assertEquals(Double.valueOf(24), linkedDouble.getFirst());
		linkedDouble.addToFront(71.0);
		assertEquals(Double.valueOf(71), linkedDouble.getFirst());
	}

	@Test
	public void testGetLastSTUDENT(){
		assertEquals(Double.valueOf(32), linkedDouble.getLast());
		linkedDouble.addToEnd(36.0);
		assertEquals(Double.valueOf(36), linkedDouble.getLast());
	}
	
	@Test
	public void testToArraySTUDENT(){
		ArrayList<Double> list;
		linkedDouble.addToFront(1.0);
		linkedDouble.addToEnd(3.0);
		list = linkedDouble.toArrayList();
		assertEquals(Double.valueOf(1.0), list.get(0));
		assertEquals(Double.valueOf(24.0), list.get(1));
		assertEquals(Double.valueOf(30.0), list.get(2));
		assertEquals(Double.valueOf(32.0), list.get(3));
		assertEquals(Double.valueOf(3.0), list.get(4));
	}
	
	@Test
	public void testIteratorSuccessfulNextSTUDENT(){
		
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(24.0), iterator.next());
		assertEquals(Double.valueOf(30.0), iterator.next());
		assertEquals(Double.valueOf(32.0), iterator.next());
		assertEquals(false, iterator.hasNext());
	
	}
	
	@Test
	public void testIteratorSuccessfulPreviousSTUDENT(){
		
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(24.0), iterator.next());
		assertEquals(Double.valueOf(30.0), iterator.next());
		assertEquals(Double.valueOf(32.0), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(Double.valueOf(32.0), iterator.previous());
	}
	
	
	@Test
	public void testIteratorNoSuchElementExceptionNextSTUDENT(){
		linkedDouble.addToEnd(20.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(24.0), iterator.next());
		assertEquals(Double.valueOf(30.0), iterator.next());
		assertEquals(Double.valueOf(32.0), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(20.0), iterator.next());
		try{
			
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPreviousSTUDENT(){
		
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(24.0), iterator.next());
		assertEquals(Double.valueOf(30.0), iterator.next());
		assertEquals(Double.valueOf(32.0), iterator.next());
		assertEquals(false, iterator.hasNext());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(Double.valueOf(32.0), iterator.previous());
		try{
			
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}

	@Test
	public void testIteratorUnsupportedOperationExceptionSTUDENT(){
		linkedDouble.addToEnd(20.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(24.0), iterator.next());
		assertEquals(Double.valueOf(30.0), iterator.next());
		assertEquals(Double.valueOf(32.0), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(20.0), iterator.next());
		try{
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	
	@Test
	public void testRemoveSTUDENT(){
		linkedDouble.remove(Double.valueOf(24.0), comparatorD);
		assertEquals(Double.valueOf(30.0), linkedDouble.getFirst());
	}
	
	@Test
	public void testRetrieveFirstElementSTUDENT(){
		
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(24.0), iterator.next());
		assertEquals(Double.valueOf(24.0), linkedDouble.retrieveFirstElement());
		
	}
	
	@Test
	public void testRetrieveLastElementSTUDENT(){
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		
		assertEquals(Double.valueOf(32.0), linkedDouble.retrieveLastElement());
	}

	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}

}
