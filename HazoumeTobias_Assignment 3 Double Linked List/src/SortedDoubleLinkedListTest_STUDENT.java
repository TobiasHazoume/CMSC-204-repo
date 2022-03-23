import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedListTest_STUDENT {
	DoubleComparator comparatorD;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	

	@Before
	public void setUp() throws Exception {
		

		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
	}

	@After
	public void tearDown() throws Exception {
		comparatorD = null;
		sortedLinkedDouble = null;
	}

	@Test

	public void testAddToEndSTUDENT() {
		try {
			sortedLinkedDouble.addToEnd(2.0);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test

	public void testAddToFrontSTUDENT() {
		try {
			sortedLinkedDouble.addToFront(2.0);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}


	@Test
	public void testIteratorSuccessfulDoubleNext_STUDENT() {
		
		sortedLinkedDouble.add(51.6);
		sortedLinkedDouble.add(2.4);
		sortedLinkedDouble.add(148.4);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(2.4), iterator.next());
		assertEquals(Double.valueOf(51.6), iterator.next());
		assertEquals(Double.valueOf(148.4), iterator.next());
		assertEquals(false, iterator.hasNext());
	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious_STUDENT() {
		sortedLinkedDouble.add(51.6);
		sortedLinkedDouble.add(2.4);
		sortedLinkedDouble.add(148.4);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(2.4), iterator.next());
		assertEquals(Double.valueOf(51.6), iterator.next());
		assertEquals(Double.valueOf(148.4), iterator.next());
		assertEquals(false, iterator.hasNext());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(Double.valueOf(148.4), iterator.previous());
		
	}
	
	@Test

	public void testIteratorNoSuchElementException_STUDENT() {
		sortedLinkedDouble.add(25.0);
		sortedLinkedDouble.add(51.6);
		sortedLinkedDouble.add(2.4);
		sortedLinkedDouble.add(148.4);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(2.4), iterator.next());
		assertEquals(Double.valueOf(25.0), iterator.next());
		assertEquals(Double.valueOf(51.6), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(148.4), iterator.next());
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

	public void testIteratorUnsupportedOperationExceptionSDouble() {
		sortedLinkedDouble.add(25.0);
		sortedLinkedDouble.add(51.6);
		sortedLinkedDouble.add(2.4);
		sortedLinkedDouble.add(148.4);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
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

	public void testAdd_STUDENT() {
		sortedLinkedDouble.add(25.0);
		sortedLinkedDouble.add(51.6);
		sortedLinkedDouble.add(2.4);
		sortedLinkedDouble.add(148.4);
		assertEquals(Double.valueOf(2.4), sortedLinkedDouble.getFirst());
		assertEquals(Double.valueOf(148.4), sortedLinkedDouble.getLast());
		
		
	}
	
	
	@Test

	public void testRemoveFirst_STUDENT() {
		sortedLinkedDouble.add(25.0);
		sortedLinkedDouble.add(51.6);
		sortedLinkedDouble.add(2.4);
		sortedLinkedDouble.add(148.4);
		assertEquals(Double.valueOf(2.4), sortedLinkedDouble.getFirst());
		assertEquals(Double.valueOf(148.4), sortedLinkedDouble.getLast());
		sortedLinkedDouble.remove(Double.valueOf(2.4), comparatorD);
	}
	
	@Test

	public void testRemoveEnd_STUDENT() {
		
		sortedLinkedDouble.add(25.0);
		sortedLinkedDouble.add(51.6);
		sortedLinkedDouble.add(2.4);
		sortedLinkedDouble.add(148.4);
		assertEquals(Double.valueOf(2.4), sortedLinkedDouble.getFirst());
		assertEquals(Double.valueOf(148.4), sortedLinkedDouble.getLast());
		sortedLinkedDouble.remove(Double.valueOf(148.4), comparatorD);
	}
	
	@Test

	public void testRemoveMiddle_STUDENT() {
		sortedLinkedDouble.add(25.0);
		sortedLinkedDouble.add(51.6);
		sortedLinkedDouble.add(2.4);
		sortedLinkedDouble.add(148.4);
		assertEquals(Double.valueOf(2.4), sortedLinkedDouble.getFirst());
		assertEquals(Double.valueOf(148.4), sortedLinkedDouble.getLast());
		sortedLinkedDouble.remove(Double.valueOf(51.6), comparatorD);
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
