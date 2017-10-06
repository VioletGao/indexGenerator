import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class IndexEntryTest {

	private IndexEntry i;
	
	@Before
	public void setUp() throws Exception {
		i = new IndexEntry("A");
	}

	@After
	public void tearDown() throws Exception {
		i = null;
	}

	@Test
	public void testIndexEntry() {
		assertEquals("Constructor", "A{}", i.toString());
	}

	@Test
	public void testAddPage() {
		i.addPage(2);
		assertEquals("Constructor", "A{2}", i.toString());
	}

	@Test
	public void testFindPage() {
		i.addPage(1);
		assertEquals("Find", true, i.findPage(1));
	}

	@Test
	public void testIsFull() {
		i.addPage(1);
		i.addPage(2);
		i.addPage(3);
		i.addPage(4);
		assertEquals("Is full", true, i.isFull());
	}

	@Test
	public void testToString() {
		i.addPage(1);
		i.addPage(3);
		assertEquals("To string", "A{1, 3}", i.toString());
	}

	@Test
	public void testCompareTo() {
		IndexEntry newEntry = new IndexEntry("A");
		i.addPage(1);
		newEntry.addPage(3);
		assertEquals("Compare to", 0, i.compareTo(newEntry));
	}

}
