package queueQ2;

/** Generating the queue interface */
interface QueueInterface<T> {
    void enQueue(T item);
    T deQueue();
    boolean isEmpty();
    boolean isFull();
    void display();
}
