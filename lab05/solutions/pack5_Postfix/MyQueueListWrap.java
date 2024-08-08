package solutions.pack5_Postfix;

import java.util.Iterator;
import java.util.LinkedList;

public class MyQueueListWrap<T> implements Iterable<T> {
    private LinkedList<T> list;

    public MyQueueListWrap() {
        list = new LinkedList<>();
    }

    public void enqueue(T element) {
        list.addLast(element);
    }

    public T dequeue() {
        return list.pollFirst();
    }

    public T top() {
        return list.peekFirst();
    }

    public T getLast(){
        return list.peekLast();
    }

    // Implementing the Iterable interface
    @Override
    public Iterator<T> iterator() {
        return new MyQueueIterator();
    }

    // Inner class to provide the iterator
    private class MyQueueIterator implements Iterator<T> {
        private Iterator<T> iterator = list.iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public T next() {
            return iterator.next();
        }
    }

    public String dumpToString() {
        StringBuilder sb = new StringBuilder();
        for (T item : list) {
            sb.append(item).append(" ");
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return dumpToString();
    }
}
