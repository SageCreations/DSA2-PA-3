import java.io.*;

class HashTable {
    private Tree[] hashArray; // array holds hash table
    private int arraySize;
    private Tree nonItem; // for deleted items
    // -------------------------------------------------------------
    public HashTable(int size) // constructor
    {
        arraySize = size;
        hashArray = new Tree[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new Tree("Tree " + i);
            System.out.printf("index %d instantiated.\n", i);
        }
        nonItem = new Tree(); // deleted item key is -1
    }
    // -------------------------------------------------------------
    public void displayTable() {
        System.out.print("Table: ");
        for(int j=0; j<arraySize; j++) {
            if(hashArray[j] != null)
                hashArray[j].displayTree();
            else
                System.out.print("** ");
        }
        System.out.println("");
    }
    // -------------------------------------------------------------
    public int hashFunc(int key) {
        return key % arraySize; // hash function
    }
    // -------------------------------------------------------------
    public void insert(Node item) // insert a DataItem
    // (assumes table not full)
    {
        int key = item.getKey(); // extract key
        int hashVal = hashFunc(key); // hash the key
        // until empty cell or -1,
        /*while(hashArray[hashVal] != null) {  // was here: && hashArray[hashVal].getKey() != -1
            ++hashVal; // go to next cell
            hashVal %= arraySize; // wraparound if necessary
        }*/ // This portion isnt needed since we can just serperate chain using the BST
        hashArray[hashVal].insert(item);  // insert item
    } // end insert()
    // -------------------------------------------------------------
    public Node delete(int key) // delete a DataItem
    {
        int hashVal = hashFunc(key); // hash the key
        while(hashArray[hashVal] != null) // until empty cell,
            {
                // found the key?
                if(hashArray[hashVal].find(key).getKey() == key) {
                    Node temp = hashArray[hashVal].find(key); // save item
                    hashArray[hashVal] = nonItem; // delete item
                    return temp; // return item
                }
                ++hashVal; // go to next cell
                hashVal %= arraySize; // wraparound if necessary
            }
        return null; // can’t find item
    } // end delete()
    // -------------------------------------------------------------
    public Node find(int key) // find item with key
    {
        int hashVal = hashFunc(key); // hash the key
        while(hashArray[hashVal] != null) // until empty cell,
            {
                // found the key?
                if(hashArray[hashVal].find(key).getKey() == key)
                    return hashArray[hashVal].find(key); // yes, return item
                ++hashVal; // go to next cell
                hashVal %= arraySize; // wraparound if necessary
            }
        return null; // can’t find item
    }
    // -------------------------------------------------------------
} // end class HashTable
////////////////////////////////////////////////////////////
