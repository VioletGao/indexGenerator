/**
 * Creates a word index for given text file 
 * @author Yuan Gao
 * @version 6/4/2015
 */
public class Client {

	public static void main(String[] args) {
		
		Index i = new Index();
		
		//System.out.println("Test file 1: ");
		//i.createIndex("src/input.txt");
		
		System.out.println("\nTest file 2: ");
		i.createIndex("src/usconst.txt");
		
		//System.out.println("\nTest file 3: ");
		//i.createIndex("src/Machiavelli.txt");

	}
	
}
