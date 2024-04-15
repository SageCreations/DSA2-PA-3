// Originally from Textbook, a merge of Listing's 8.1 and 12.1 Node class.
// Edited by Edward Cruz to make work with both DS classes.

class Node {
    // Left this public because the Tree class uses them like so.
    public int iData; // data item (key)
    
    Node leftChild; // this node’s left child public
    Node rightChild; // this node’s right child public



    //created this default constructor to keep the Tree class from freaking out.
    public Node() {
        iData = 0;
        //dData = 0.0;
    }

    public Node(int key) // constructor CHAPTER 12 Heaps592
    {
        iData = key;
        //dData = 0.0; // added this
    } // -------------------------------------------------------------
    
    public int getKey() {
        return iData;
    } // -------------------------------------------------------------

    public void setKey(int id) {
        iData = id;
    } // -------------------------------------------------------------

    void displayNode() // display ourself
    {
        // Output result: "iData"
        System.out.print('{');
        System.out.print(iData);
        System.out.print("} ");
    }
} // end class Node ////////////////////////////////////////////////////////////////