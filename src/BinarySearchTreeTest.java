import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BinarySearchTreeTest {

	private BinarySearchTree<String> tree;
	
	@Before
	public void setUp() throws Exception {
		tree = new BinarySearchTree<String> ();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}


	@Test
	public void testConstructor () {
		assertEquals ("A new tree should be empty", "", tree.toString());
	}
	
	@Test
	public void testAdd_toEmptyTree () {
		tree.add("K");
		assertEquals ("empty tree + K", "K", tree.toString());
	}

	@Test
	public void testAddShowTree_toEmptyTree () {
		tree.add("K");
		assertEquals ("empty tree + K", "K", tree.showTree());
	}
	
	@Test
	public void testAdd_depthZeroTreeLeftChild () {
		tree.add("K");
		tree.add("D");
		assertEquals ("K + D", "D\nK", tree.toString());
	}

	@Test
	public void testAddShowTree_depthZeroTreeLeftChild () {
		tree.add("K");
		tree.add("D");
		assertEquals ("K + D", "K\n D", tree.showTree());
	}

	@Test
	public void testAdd_depthZeroTreeRightChild () {
		tree.add("K");
		tree.add("Z");
		assertEquals ("K + Z", "K\nZ", tree.toString());
	}

	@Test
	public void testAddShowTree_depthZeroTreeRightChild () {
		tree.add("K");
		tree.add("Z");
		assertEquals ("K + Z", "K\n Z", tree.showTree());
	}
	
	@Test
	public void testAdd_duplicates () {
		tree.add("K");
		tree.add("K");
		assertEquals ("K + K", "K\nK", tree.toString());
	}
	
	@Test
	public void testAddShowTree_duplicates () {
		tree.add("K");
		tree.add("K");
		assertEquals ("K + K", "K\n K", tree.showTree());
	}
	
	@Test
	public void testAdd_levelThreeFullTree() {
		tree.add("K");
		tree.add("D");
		tree.add("P");
		tree.add("B");
		tree.add("F");
		tree.add("M");
		tree.add("Q");
		assertEquals ("A tree has 3 levels and is full", "B\nD\nF\nK\nM\nP\nQ", tree.toString());
	}

	@Test
	public void testAddShowTree_levelThreeFullTree() {
		tree.add("K");
		tree.add("D");
		tree.add("P");
		tree.add("B");
		tree.add("F");
		tree.add("M");
		tree.add("Q");
		assertEquals ("A tree has 3 levels and is full", "K\n D\n  B\n  F\n P\n  M\n  Q", tree.showTree());
	}

	
	@Test
	public void testRemove_fromEmptyTree () {
		assertEquals ("Remove A from empty tree", null, tree.remove("A"));
	}
	
	@Test
	public void testRemove_dataNotFound () {
		tree.add("P");
		tree.add("B");
		tree.add("F");
		tree.add("M");
		assertEquals ("Remove A, A not in this tree", null, tree.remove("A"));
	}
	
	@Test
	public void testRemove_oneElement () {
		tree.add("A");
		assertEquals ("Remove A from {A}", "A", tree.remove("A"));
	}
	
	@Test
	public void testRemove_removeRoot () {
		tree.add("K");
		tree.add("D");
		tree.add("P");
		assertEquals ("Remove root from tree", "K", tree.remove("K"));
	}
	
	@Test
	public void testRemove_removeLeftChild () {
		tree.add("K");
		tree.add("D");
		tree.add("P");
		assertEquals ("Remove left child from tree", "D", tree.remove("D"));
	}
	
	@Test
	public void testRemove_removeRightChild () {
		tree.add("K");
		tree.add("D");
		tree.add("P");
		assertEquals ("Remove right child from tree", "P", tree.remove("P"));
	}
	
	@Test
	public void testRemove_haveDuplicates () {
		tree.add("A");
		tree.add("K");
		tree.add("A");
		tree.add("P");
		assertEquals ("Remove A from a tree has two As", "A", tree.remove("A"));
	}
	
	@Test
	public void testRemove_duplicates () {
		tree.add("A");
		tree.add("K");
		tree.add("A");
		tree.add("P");
		tree.remove("A");
		tree.remove("A");
		assertEquals ("Remove all A in tree", "K\nP", tree.toString());
	}
	
	
	@Test
	public void testFind_emptyTree () {
		assertEquals ("Finds in an empty tree", null, tree.find("A"));
	}

	@Test
	public void testFind_nonEmptyTree_notFound () {
		tree.add("B");
		assertEquals ("Finds in a non empty tree with no found data", null, tree.find("A"));
	}
	
	@Test
	public void testFind_nonEmptyTree_findChild () {
		tree.add("K");
		tree.add("D");
		tree.add("P");
		assertEquals ("Finds a child in a non empty tree", "P", tree.find("P"));
	}

	@Test
	public void testFind_nonEmptyTree_findRoot () {
		tree.add("K");
		tree.add("D");
		tree.add("P");
		assertEquals ("Finds a root in a non empty tree", "K", tree.find("K"));
	}
	
	@Test
	public void testShowTree_emptyTree () {
		assertEquals ("Shows an empty treer", "", tree.showTree());
	}
	
	@Test
	public void testShowTree () {
		tree.add("F");
		tree.add("B");
		tree.add("G");
		tree.add("A");
		tree.add("D");
		tree.add("C");
		tree.add("E");
		tree.add("I");
		tree.add("H");
		assertEquals ("Shows tree in pre-order", "F\n B\n  A\n  D\n   C\n   E\n G\n  I\n   H", tree.showTree());
	}
}
