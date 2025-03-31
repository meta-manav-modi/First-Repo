package loopInList;

/**class Node, used to create a node having data and next node reference */
public class Node {
    int data;
    public Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }

    public int getData(){
        return data;
    }
}
