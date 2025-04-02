package queueQ2;

/** class CircularQueue, used to define all the methods like enqueue, dequeue, isFull or isEmpty */
public class CircularQueue<T>  implements QueueInterface<T>  {
    private int maxSize;
    private int size;
    private int front;
    private int rear;
    private T[] items;

    
    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        this.items = (T[]) new Object[maxSize];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }
    
    // check if queue is full or not
    public boolean isFull() {
        return size == maxSize;
    }


    // check if queue is empty or not
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    /** method enqueue, used to add leemnet to the queue
     * @ param , integer element
     */
    public void enQueue(T element) {
        if (isFull()) {
            throw new AssertionError("Queue is full");
        } else {
            if(isEmpty()){
                front = 0;
            }
            rear = (rear + 1) % maxSize;
            items[rear] = element;
            size++;
        }
    }

    /** method dequeue, used to delete an element from queue
     * @ return the deleted element
     */
    public T deQueue() {
        T element;
        if (isEmpty()) {
            throw new AssertionError("Queue is empty");
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } 
            else {
                front = (front + 1) % maxSize;
            }
            size--;
            return (element);
        }
    }

    //print the queue elements
    public void display() {

        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.println("Queue is");
            for (i = front; i != rear; i = (i + 1) % size)
                System.out.print(items[i] + " ");
            System.out.println(items[i]);
            System.out.println("Rear -> " + rear);
        }
    }
}
