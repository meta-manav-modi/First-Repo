package stackQ1;

import java.util.ArrayList;

/** class StackArr, used to define all the methods of stack interface
 * like push, pop, peek, isEmpty
 */
class StackArr<T> implements Stack<T> {
    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void push(T element) {
        this.list.add(element);
    }

    @Override
    public T peek() {
        if (this.list.isEmpty())
            return null;
        return this.list.get(this.list.size() - 1);
    }

    @Override
    public T pop() {
        if (this.list.isEmpty())
            return null;
        return this.list.remove(this.list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
