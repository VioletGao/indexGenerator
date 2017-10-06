/**
 * Represents a binary search tree
 * @author Yuan Gao
 * @version 6/4/2015
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private BSTNode<T> root;
	
	/**
	 * creates a binary search tree
	 */
	public BinarySearchTree() {
		root = null;
	}
	
	/**
	 * finds a node with certain value
	 * @param toFind data to be found
	 * @return the value stored in the found node
	 */
	public T find(T toFind) {
		BSTNode<T> runner = root;
		
		return find(runner, toFind);
	}
	
	// helper find method
	private T find(BSTNode<T> root, T toFind) {
		if (root == null) {
			return null;
		}
		else if (toFind.compareTo(root.data) == 0) {
			return root.data;
		}
		else if (toFind.compareTo(root.data) > 0) {
			return find(root.right, toFind);
		}
		else {
			return find(root.left, toFind);
		}
	}
	
	/**
	 * adds a new node with the value toAdd to the tree
	 * @param toAdd
	 */
	public void add(T toAdd) {
		BSTNode<T> cursor = root;
		root = add(cursor, toAdd);
	}
	
	// helper add method 
	private BSTNode<T> add(BSTNode<T> root, T toAdd) {
		BSTNode<T> newNode = new BSTNode<T>(toAdd);
		if (root == null) {
			root = newNode;
		}
		else {
			if (toAdd.compareTo(root.data) > 0) {
				root.right = add(root.right, toAdd);
			}
			else {
				root.left = add(root.left, toAdd);
			}
		}
		return root;
	}
	
	/**
	 * finds the node in the tree that stores a value equals toRemove
	 * delete the node and return the value in that node
	 * @param toRemove
	 * @return the value in that node
	 */
	public T remove(T toRemove) {
		BSTNode<T> cursor = root;
		T removedData = removedData(cursor, toRemove);
		root = remove(cursor, toRemove);
		
		return removedData;
	}
	
	// helper remove method
	private BSTNode<T> remove(BSTNode<T> root, T toRemove) {
		if (root != null) {
			if (toRemove.compareTo(root.data) == 0) {
				if (root.left == null && root.right == null) {
					root = null;
				}
				else if (root.left == null) {
					root = root.right;
				}
				else {
					root.data = findMax(root.left);
					root.left = remove(root.left, root.data);
				}
			}
			else {
				if (toRemove.compareTo(root.data) > 0) {
					root.right = remove(root.right, toRemove);
				}
				else {
					root.left = remove(root.left, toRemove);
				}
			}
		}
		return root;
		
	}
	
	// find the largest value in a subtree
	private T findMax(BSTNode<T> root) {
		while (root.right != null) {
			root = root.right;
		}
		return root.data;
		
	}
	
	// helper find removed data method
	private T removedData(BSTNode<T> root, T toRemove) {
		T removedData = null;
		if (root != null) {
			if (toRemove.compareTo(root.data) == 0) {
				removedData = root.data;
			}
			else {
				if (toRemove.compareTo(root.data) > 0) {
					removedData = removedData(root.right, toRemove);
				}
				else {
					removedData = removedData(root.left, toRemove);
				}
			}	
		}
		return removedData;
	}
	
	/**
	 * @return a string that shows node data in order
	 */
	public String toString() {
		BSTNode<T> cursor = root;
		return toString(cursor);
	}
	
	// helper toString method
	private String toString(BSTNode<T> root) {
		String str = "";
		if (root != null) {
			if (root.left != null) {
				str += toString(root.left) + "\n";
			}
			
			str += root.toString();
			
			if (root.right != null) {
				str += "\n" + toString(root.right);
			}
		}
		return str;
	}

	/**
	 * @return a string that shows node data in pre-order
	 */
	public String showTree() {
		BSTNode<T> cursor = root;
		return showTree(cursor, 0);
	}
	
	// helper toString method
	private String showTree(BSTNode<T> root, int level) {
		String str = "";
		if (root != null) {
			str += printSpace(level) + root.toString();
			if (root != null) {
				if (root.left != null) {
					str += "\n" + showTree(root.left, level+1);
				}
				if (root.right != null) {
					str += "\n" + showTree(root.right, level+1);
				}
			}
		}
		return str;
	}
	
	// print spaces based on levels
	private String printSpace(int level) {
		String space = "";
		for(int i = 0; i < level; i++) {
			space += " ";
		}
		return space;
	}
	
}