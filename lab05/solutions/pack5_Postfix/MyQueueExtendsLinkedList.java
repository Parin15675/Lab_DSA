package solutions.pack5_Postfix;

import java.util.LinkedList;

public class MyQueueExtendsLinkedList<T> extends LinkedList<T> {

    public void enqueue(T d) {
        this.addLast(d);
    }

    public T dequeue() {
        return this.pollFirst();
    }

    public T top() {
        return this.peekFirst();
    }

    // public String dumpToString() {
    //     StringBuilder sb = new StringBuilder();
    //     for (T item : queue) {
    //         sb.append(item).append(" ");
    //     }
    //     return sb.toString().trim();
    // }

}

