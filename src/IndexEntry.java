/**
 * An entry of index
 * @author Yuan Gao
 * @version 6/1/2015
 */
public class IndexEntry implements Comparable<IndexEntry>{

	private String data;
	private GenericLinkedList<Integer> page;

	/**
	 * Creates a new index entry
	 * @param the word in this entry
	 * @param the page of this word
	 */
	public IndexEntry(String word) {
		data = word;
		page = new GenericLinkedList<Integer>();
	}

	/** 
	 * Adds a new index
	 * @param newIndex
	 */
	public void addPage(int newPage) {
		page.addAtTail(newPage);
	}
	
	/**
	 * find if a page index is already in the linked list
	 * @param pageNum
	 * @return true if the page number is already in the list
	 */
	public boolean findPage(int pageNum) {

		return (page.find(pageNum) != null); 
	}
	
	/**
	 * @return true if the size of page is 4
	 */
	public boolean isFull() {
		return (page.size() == 4);
	}

	/**
	 * @return a string contains the word and index list
	 */
	public String toString() {
		return data + page.toString();
	}
	
	/**
	 * Compare this index entry to another 
	 */
	public int compareTo(IndexEntry anotherEntry) {
		return data.compareTo(anotherEntry.data);
	}
}