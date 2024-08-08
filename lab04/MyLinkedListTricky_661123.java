package solutions.pack3;

public class MyLinkedListTricky_661123 extends MyLinkedList_661123 {

    public void q1_rotate_counterclockwise(int k) {
        Node current = head;
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if (current == null){
            return;
        }


        Node x = current;
        while (current.next != null) {
            current = current.next;
        }

        current.next = head;
        head = x.next;
        x.next = null;
    }

    public void q2_reverse() {
        Node x = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = x;
            x = current;
            current = next;
        }

        head = x;
    }

    public void q3_remove_dup() {
        Node current = head;
        Node result = null;
        Node resultTail = null;

        while (current != null) {
            Node x = head;
            boolean dup = false;

            while (x != current) {
                if (x.data == current.data) {
                    dup = true;
                    break;
                }
                x = x.next;
            }

            if (!dup) {
                Node newNode = new Node(current.data);
                if (result == null) {
                    result = newNode;
                    resultTail = newNode;
                } else {
                    resultTail.next = newNode;
                    resultTail = newNode;
                }
            }

            current = current.next;
        }

        head = result;
    }

    public void q4_add_one() {
        q2_reverse();
        Node current = head;
        int number = 0;
        int mutiple = 1;

        while (current != null) {
            number = number + (current.data * mutiple);
            current = current.next;
            mutiple = mutiple * 10;
        }

        number += 1;

        head = null;
        while (number > 0) {
            int digit = number % 10;
            number = number / 10;
            Node newNode = new Node(digit);
            newNode.next = head;
            head = newNode;
        }

    }

    public boolean q5_isPalindrome() {
        Node original = copyList(head);
        q2_reverse();
        Node reversed = head;

        Node check = original;
        Node current = reversed;
        boolean isPalindrome = true;
        // int count = 0;

        while (check != null && current != null) {
            if (check.data == current.data) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
            current = current.next;
            check = check.next;
            count++;
        }
        // System.out.println(count);
        q2_reverse();
        return isPalindrome;
    }

    private Node copyList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.data);
        Node current = head.next;
        Node newCurrent = newHead;

        while (current != null) {
            newCurrent.next = new Node(current.data);
            newCurrent = newCurrent.next;
            current = current.next;
        }
        return newHead;
    }

}
