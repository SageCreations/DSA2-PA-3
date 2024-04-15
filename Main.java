import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random rand = new Random();
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int hashSize;
        do {
            System.out.print("Please input the number of area codes you want (greater than 4 and less than or equal to 320): ");
            hashSize = scan.nextInt();
            scan.nextLine();
        } while (hashSize < 4 || hashSize > 320);


        // instnatiate HashTable with hashSize from user prompt divided by 4
        HashTable myHash = new HashTable(hashSize/4); 
        int[] dupes = new int[899];  // instantiate dupe checking tally array
        for (int i = 0; i < hashSize; i++) {
            // ** Chose option one, tally process. ** O(1) checking operation
            boolean isDupe; // flag for dupe
            int rando; // random area code
            do { // loop if flag check fails
                isDupe = false;
                rando = rand.nextInt(899)+100;
                if (dupes[rando-100] == 1) {
                    isDupe = true;
                } else {
                    dupes[rando-100] = 1;
                }
            } while (isDupe);

            Node newNode = new Node(rando); // node with the random int
            myHash.insert(newNode); // insert node into hashtable of Trees
        }

        myHash.displayTable();



        scan.close();
    }
}