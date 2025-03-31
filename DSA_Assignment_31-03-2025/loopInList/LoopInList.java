package loopInList;

/** class LoopInList , used to define functions like,insert node, isLoppDetected
 * create a loop
 */
public class LoopInList {
    Node head;

    /** method insert, used to create a node and insert into list
     * @ param data in int type
     */
    public void insert(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);

    }

    /**method isLoopDetected, used to check a loop is prent or not
     * @ return, boolean value
     */
    public boolean isLoopDetected(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast)){
                return true;
            }
        }
        return false;
    }

    /**method createLoop, used to create a loop 
     * @ param, int position to create loop
     */
    public void createLoop(int pos){
        if(head == null) return;

        Node temp = head;
        Node loopNode = null;
        int count = 1;
        while (temp.next != null) {
            if(count == pos){
                loopNode = temp;
            }
            temp = temp.next;
            count++;
        }
        temp.next = loopNode;
    }
}
