package stackQ1;

/** interface Stack */
interface Stack<T> {
    void push(T element);

    T pop();

    T peek();

    boolean isEmpty();
}