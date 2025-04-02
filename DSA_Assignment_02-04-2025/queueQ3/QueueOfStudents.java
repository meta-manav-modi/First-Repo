package queueQ3;


/** class QueueOfStudents, used to add student into the squeue */
public class QueueOfStudents implements QueueInterface {

    private QueueNode front;
    private QueueNode rear;

    public QueueOfStudents() {
        this.front = null;
        this.rear = null;
    }
    
    // Getters
    public QueueNode getFront() {
        return front;
    }

    public QueueNode getRear() {
        return rear;
    }

    /** method enqueue, add students to queue
     * @ param, object of Student class
     */
    public void enqueue(Student student) {

        QueueNode newNode = new QueueNode(student);
        if (rear == null) {
            rear = newNode;
            front = rear;

        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}