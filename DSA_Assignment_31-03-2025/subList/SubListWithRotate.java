package subList;

/** class SubListWithRotate , used to define functions like,insert node, isLoppDetected
 * Rotate a substring and display the linked list
 */
public class SubListWithRotate {
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

    /** method rotateSubList, it find the subList and call the rotate function to roate that subList
     * @ param start index of subList
     * @ param end index of subList
     * @ param number of rotations on subList
     */
    public void rotateSubList(int startIndex, int endIndex, int numOfRotations){
        if( head == null || startIndex >= endIndex || endIndex < 1 || startIndex < 1 ||numOfRotations < 0){
            throw new AssertionError("Invalid values of indexes");
        }

        Node beforeStartIndex = null;
        Node start = head;
        for(int index = 1; index < startIndex && start != null; index++){
            beforeStartIndex = start;
            start = start.next;
        }
        if(start == null) throw new IllegalArgumentException("startIndex is out of bounds");

        Node end = start;
        Node afterEndIndex = null;
        for(int index = startIndex; index < endIndex && end != null; index++){
            end = end.next;
        }
        if(end == null) throw new IllegalArgumentException("endIndex is out of bounds");

        afterEndIndex = end.next;
        end.next = null;

        //call the rotate method, to rotate subList
        Node rotatedHead = rotate(start, numOfRotations);

        if(beforeStartIndex != null){
            beforeStartIndex.next = rotatedHead;
        }else{
            head = rotatedHead;
        }

        Node temp = rotatedHead;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = afterEndIndex;
    }

    /** method rotate, used to rotate a list
     * @ param starting node
     * @ param number of rotations
     * @ return starting node after rotation
     */
    private Node rotate(Node start, int numOfRotations){
        if(start == null) return null;

        int length = 0;
        Node temp = start;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        numOfRotations = numOfRotations % length;
        if(numOfRotations == 0) return start;

        Node prev = null, current = start;
        for(int index = 0; index < length - numOfRotations; index++){
            prev = current;
            current = current.next;
        }
        prev.next = null;
        Node newHead = current;
        while(current.next != null){
            current = current.next;
        }
        current.next = start;
        return newHead;
    }

    /** method display, used to print the linked list
     * @ return linked list
     */
    public String display(){
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data).append("->");
            temp = temp.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
