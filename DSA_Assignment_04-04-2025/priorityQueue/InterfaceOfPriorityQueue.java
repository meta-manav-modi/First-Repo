package priorityQueue;

/** create an interface for priority queue */
interface InterfaceOfPriorityQueue< T extends Comparable<T>> {
    void insert(T element);
    T remove();
    T peek();
    boolean isEmpty();
    boolean isFull();
}
