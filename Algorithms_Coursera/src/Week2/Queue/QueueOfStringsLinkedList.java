package Week2.Queue;

/*
Queue
FIFO
 */

public class QueueOfStringsLinkedList {
    private Node first;
    private Node last;
    private int n = 0;

    // inner class Node
    private class Node {
        String item;
        Node next;
    }

    public QueueOfStringsLinkedList() {
    }

    // insert a new string onto queue
    public void enqueue(String item) {
        Node oldLast = this.last;
        this.last = new Node();
        this.last.item = item;
        this.last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

        this.n++;
    }

    // remove and return the current first string
    public String dequeue() {
        String item;
        if (!isEmpty()) {
            item = first.item;
            first = first.next;
            this.n--;
        } else {
            System.out.println("there is no item left.");
            item = null;
        }

        if (isEmpty()) {
            last = null;
        }

        return item;
    }

    // is the queue empty?
    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        QueueOfStringsLinkedList queue = new QueueOfStringsLinkedList();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");
        System.out.println("queue size now: " + queue.size());
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
