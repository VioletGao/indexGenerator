/**
 * Represents a binary search tree node
 * @author Yuan Gao
 * @version 6/4/2015
 */
public class BSTNode<T> {

	public T data;
	public BSTNode<T> left;
	public BSTNode<T> right;
	
	/**
	 * creates a new node with new data
	 * @param data
	 */
	public BSTNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	/**
	 * @return a string represents the data
	 */
	public String toString() {
		return data.toString();
	}
}
