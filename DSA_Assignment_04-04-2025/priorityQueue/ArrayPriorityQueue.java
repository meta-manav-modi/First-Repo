package priorityQueue;

/** class used to perform all operations on priority queue */
public class ArrayPriorityQueue<T extends Comparable<T>> implements InterfaceOfPriorityQueue<T> {
    private T[] heap;
    private int size;
    private int maxSize;
    
    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue(int maxSize) {
        this.heap = (T[]) new Comparable[maxSize];
        this.size = 0;
        this.maxSize = maxSize;
    }

    // Insert an element to priority Queue
    @Override
    public void insert(T element){
        if(size == maxSize){
            throw new AssertionError("Priority queue is full");
        }
        heap[size] = element;
        int curr = size;
        size++;
        while (curr > 0 && heap[curr].compareTo(heap[(curr - 1) / 2]) > 0) {
            swap(curr, (curr - 1) / 2);
            curr = (curr - 1) / 2;
        }
    }

    // Remove an element from priority queue
    @Override
    public T remove(){
        if(isEmpty()){
            throw new AssertionError("Queue is empty");
        }
        T max = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return max;
    }

    // check priority queue is empty or not
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    // return the max element from priority queue
    @Override
    public T peek(){
        if(isEmpty()){
            throw new AssertionError("Queue is empty");
        }
        return heap[0];
    }

    // check priority queue is full or not
    @Override
    public boolean isFull(){
        return size == maxSize;
    }

    // swap two values 
    private void swap(int first, int second){
        T temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    // manage the maxHeap for priority queue
    private void heapify(int index){
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if(left < size && heap[left].compareTo(heap[largest]) > 0){
            largest = left;
        }
        if(right < size && heap[right].compareTo(heap[largest]) > 0){
            largest = right;
        }
        if(largest != index){
            swap(index, largest);
            heapify(largest);
        }
    }
}
