package solutions.pack3;

public class MyLinkedList_661123 {

    public class Node {

        int data;
        Node next;

        public Node(int d) {
            data = d;
        }
    }
    Node head = null;

    public void add(int d) {
        Node p = new Node(d);
        p.next = head;
        head = p;
    }

    public void insert(int d) {
        Node newNode = new Node(d);

        if (head == null || head.data >= d) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < d) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int find(int d) {
        Node current = head;
        int x = 0;
        while (current != null) {
            if (current.data == d) {
                return x;
            }
            current = current.next;
            x++;
        }

        return -1;
    }

    public int size(){
        Node current = head;
        int x = 0;
        while (current != null){
            x++;
            current = current.next;
        }
        return x;
    }



   public void delete(int d) {
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while ((p.next != null) && (p.next.data != d)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        head = t.next;
    }

    public void add(int[] d) {
        if (d != null && d.length > 0) { 
            for (int i = d.length - 1; i >= 0; i--) {
                add(d[i]);
            }
        }
    }

    public void insert(int[] d) {
        if (d != null && d.length > 0) {
            for (int i = 0; i < d.length; i++) {
                insert(d[i]);
            }
        }
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while (p != null) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        sb.append("-> null");
        return new String(sb);
    }
}
