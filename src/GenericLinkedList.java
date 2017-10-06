/**
 * This Linked List can contain any object type.
 * 
 * The invariant of LinkedList is:
 *    1.The number of elements in the sequence is stored in the instance variable size
 *    2.The head reference of the list is stored in the instance variable head
 *   
 * @author Yuan Gao
 * @version 5/15/2015
 */
public class GenericLinkedList<T extends Comparable<T>> {
	
	private GenericListNode<T> head;
	private int size;
	
	/**
	 * creates a new linked list
	 */
	public GenericLinkedList() {
		head = null;
	}

	/**
	 * @return the size of linked list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * adds a new node contains value toAdd
	 * to the end of linked list
	 * @param data to be added
	 */
	public void addAtTail(T toAdd) {
		GenericListNode<T> newNode = new GenericListNode<T>(toAdd);
		
		if (size == 0) {
			head = newNode;
		} 
		else {
			GenericListNode<T> runner = head;
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = newNode;
		}
		size ++;
	}
	
	/**
	 * finds the first node whose data match toFind
	 * @param the data to be found 
	 * @return data found
	 */
	public T find(T toFind) {
		GenericListNode<T> runner = head;
		T foundData = null;
		while (runner != null && foundData == null) {
			if (runner.data.compareTo(toFind) == 0) {
				foundData = runner.data;
			}
			runner = runner.next;
		}
		return foundData;
	}
	
	/**
	 * @return a string represents the LinkedList
	 */
	public String toString() {
		String str = "{";
		GenericListNode<T> runner = head;
		
		while (runner != null) {
			str += runner.data;
			if (runner.next != null) {
				str += ", ";
			}
			runner = runner.next;
		}
		str += "}";
		
		return str;
	}
	
}
