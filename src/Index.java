/**
 * Contains all index of words and a dictionary
 * @author Yuan Gao
 * @version 6/1/2015
 */
public class Index {

	private BinarySearchTree<IndexEntry> index;
	private BinarySearchTree<String> dictionary;
	
	/**
	 * Creates a new index and a dictionary
	 */
	public Index() {
		index = new BinarySearchTree<IndexEntry>();
		dictionary = new BinarySearchTree<String>();
	}
	
	/**
	 * @return true if the word is found in dictionary
	 */
	public boolean findInDictionary(String word) {
		
		return (word.equals(dictionary.find(word)));
	}
	
	/**
	 * @return true if the word is found in dictionary
	 */
	public boolean findInIndex(String word) {
	
		return (findEntry(word) != null);
	}
	
	/**
	 * remove a given word from index
	 * @param word
	 */
	public void deleteFromIndex(String word) {
		IndexEntry toDelete = findEntry(word);
		index.remove(toDelete);
	}
	
	/**
	 * add the word to dictionary
	 * @param word
	 */
	public void insertToDictionary(String word) {
		dictionary.add(word);
	}
	
	/**
	 * add the word to index list
	 * @param word
	 */
	public void insertToIndex(String word, int newPage) {
		IndexEntry toAdd = new IndexEntry(word);
		toAdd.addPage(newPage);
		index.add(toAdd);
	}
	
	/**
	 * check if the page number of a word is already in the index list
	 * @param page
	 * @return true if the page number is already in index
	 */
	public boolean havePageNum(String word, int page) {
		
		IndexEntry foundEntry = findEntry(word);
		return foundEntry.findPage(page);
	}
	
	/**
	 * check if the index of that word is full
	 * @param word
	 * @return true if the index list of given word is full
	 */
	public boolean indexIsFull(String word) {
		
		IndexEntry toAdd = findEntry(word);
		return toAdd.isFull();
	}
	
	/**
	 * add a new page number to the index list
	 * @param word
	 * @param page
	 */
	public void addPage(String word, int page) {
		IndexEntry toAdd = findEntry(word);
		toAdd.addPage(page);
	}
	
	/**
	 * @param word
	 * @return a string represents the given word
	 */
	public String entryToString(String word) {
		return findEntry(word).toString();
	}
	
	/**
	 * @param word
	 * @return a string represents the whole index list
	 */
	public String indexToString() {
		return index.toString();
	}
	
	/**
	 * @param word
	 * @return a string represents the whole dictionary
	 */
	public String dictionaryToString() {
		return dictionary.toString();
	}
	
	/**
	 * given an input file, generate an index file
	 * @param filename the name of the input file
	 */
	public void createIndex(String filename) {
		Index theIndex = new Index();
		int page = 1;
		
		FileReader newFile = new FileReader(filename);
		String nextWord = newFile.nextToken();
		while (nextWord != null) {
			nextWord = nextWord.toLowerCase();
			if (nextWord.equals("#")) {
				page++;
			}
			else if (nextWord.length() >= 3 && !theIndex.findInDictionary(nextWord)) {
				if (theIndex.findInIndex(nextWord)) {
					if (! theIndex.havePageNum(nextWord, page)) {
						if (!theIndex.indexIsFull(nextWord)) {
							theIndex.addPage(nextWord, page);
						} else {
							System.out.println(theIndex.entryToString(nextWord));
							theIndex.deleteFromIndex(nextWord);
							theIndex.insertToDictionary(nextWord);
						}
					}
				} else {
					theIndex.insertToIndex(nextWord, page);
				}
			}
			nextWord = newFile.nextToken();
		}
		
		System.out.println("\nWhole index list:");
		System.out.println("-----------------------------------------------");
		System.out.println(theIndex.indexToString());
		
		System.out.println("\nWhole dictionary:");
		System.out.println("-----------------------------------------------");
		System.out.println(theIndex.dictionaryToString());
	}
	
	// helper method, given a word string, find the entry contains this word
	private IndexEntry findEntry(String word) {
		
		IndexEntry toFind = new IndexEntry(word);
		return index.find(toFind);
	}
}
