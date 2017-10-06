import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GenericLinkedListTest {

	private GenericLinkedList<String> ll;
	
	@Before
	public void setUp() throws Exception {
		ll = new GenericLinkedList<String> ();
	}

	@After
	public void tearDown() throws Exception {
		ll = null;
	}

	// There should be at most one assert statement per testing method.
	@Test
	public void testConstructor () {
		assertEquals ("New list is empty", "{}", ll.toString());
	}
	
	@Test
	public void testAddAtTail_toEmptyList () {
		ll.addAtTail("A");
		assertEquals ("{} + A", "{A}", ll.toString());
	}
	
	@Test
	public void testAddAtTail_nonEmptyList () {
		ll.addAtTail("A");
		ll.addAtTail("B");
		assertEquals ("{A} + B", "{A, B}", ll.toString());
	}

	@Test
	public void testAddAtTail_addMulti () {
		ll.addAtTail("A");
		ll.addAtTail("B");
		ll.addAtTail("C");
		ll.addAtTail("D");
		assertEquals ("A+B+C+D", "{A, B, C, D}", ll.toString());
	}
	
	@Test
	public void testFind_emptyList () {
		assertEquals ("Found nothing", null, ll.find("A"));
	}
	
	@Test
	public void testFind_valueAtHead () {
		ll.addAtTail("A");
		ll.addAtTail("B");
		assertEquals ("Found A", "A", ll.find("A"));
	}	
	
	@Test
	public void testFind_valueAtMid () {
		ll.addAtTail("A");
		ll.addAtTail("B");
		ll.addAtTail("C");
		assertEquals ("Found B", "B", ll.find("B"));
	}	
	
	@Test
	public void testFind_valueAtTail () {
		ll.addAtTail("A");
		ll.addAtTail("B");
		ll.addAtTail("C");
		assertEquals ("Found C", "C", ll.find("C"));
	}	
	
	@Test
	public void testFind_valueNoFound () {
		ll.addAtTail("A");
		ll.addAtTail("B");
		assertEquals ("Can't find D", null, ll.find("D"));
	}	
	
	@Test
	public void testSize_emptyList () {
		assertEquals ("Size of an empty list is 0", 0, ll.size());
	}

	@Test
	public void testSize_withOneItem () {
		ll.addAtTail("A");
		assertEquals ("Size of an empty list is 1", 1, ll.size());
	}
}
