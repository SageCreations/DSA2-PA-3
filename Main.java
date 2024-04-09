import java.util.Random;

public class Main {
    public static Random rand = new Random();
    
    public static void main(String[] args) {
        Tree myTree = new Tree();
        myTree.insert('H');
        myTree.insert('A');
        myTree.insert('B');
        myTree.insert('F');
        myTree.insert('Q');
        myTree.displayTree();
        
        //TODO: prompt the user for the number of area codes
        
        HashTable myHash = new HashTable(320);
        for (int i = 0; i < 320; i++) {
            DataItem item = new DataItem(rand.nextInt(899)+100);
            myHash.insert(item);
        }
        myHash.displayTable();
    }
}