package queueQ3;

/** class QueueNode, used to perform the queue using linked list */
public class QueueNode {
    Student student;
    QueueNode next;

    QueueNode(Student student) {
        this.student = student;
        this.next = null;
    }
} 
