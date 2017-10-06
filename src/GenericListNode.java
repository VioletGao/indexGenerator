/**
 * This List Node can hold any object type
 * 
 * @author Yuan Gao
 * @version 5/15/2015
 */
public class GenericListNode<T> {
	
	public T data;
	public GenericListNode<T> next;

	/**
	 * Create a new node that specified the data in node
	 * @param element
	 */
	public GenericListNode(T element) {
		data = element;
		next = null;
	}

	/**
	 * Return a string represent the data
	 */
	public String toString() {
		return data.toString();
	}
}
