package Week2.Queue;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
double site queue
 */

public class Deque<Item> implements Iterable<Item> {
    // private variable
    private int N = 0;
    private Node first;
    private Node last;

    // private inner class Node
    private class Node {
        private Item item;
        private Node next;  // refer to next node
        private Node prev;  // refer to prev node
    }


    // construct an empty deque
    public Deque() {
        N = 0;
        first = null;
        last = null;
    }

    // determine if empty
    public boolean isEmpty() {
        return N == 0;
    }

    // return number of items on the queue
    public int size() {
        return N;
    }

    // add the item to the front
    public void addFirst(Item item) {
        // check arg
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (isEmpty()) {
            first = new Node();
            first.item = item;
            first.next = null;
            first.prev = null;

            last = first;
            N++;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            first.prev = null;
            oldFirst.prev = first;
            N++;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        // check arg
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (isEmpty()) {
            first = new Node();
            first.item = item;
            first.next = null;
            first.prev = null;

            last = first;
            N++;
        } else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            last.prev = oldLast;
            oldLast.next = last;
            N++;
        }

    }

    // remove and return the item from the front
    public Item removeFirst() {
        // check empty
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        // move first to next
        Item item = first.item;
        first = first.next;
        if (first != null) {    // check if first == null
            first.prev = null;  // clean the prev refer
        }
        N--;

        // check the last refer after removing
        if (isEmpty()) {
            last = null;
        }

        return item;
    }

    // remove and return the item form the back
    public Item removeLast() {
        // check empty
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        // move last to prev
        Item item = last.item;
        last = last.prev;
        if (last != null) {     // check if last == null
            last.next = null;   // clean the next refer
        }
        N--;

        // check the first refer after removing
        if (isEmpty()) {
            first = null;
        }

        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // private inner class DequeIterator
    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit test
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();

        for (int i = 0; i < 5; i++) {
            deque.addFirst(i * 2);
        }
        for (int i = 0; i < 5; i++) {
            deque.addLast(i * 3);
        }

        StdOut.println(deque.isEmpty());
        StdOut.println(deque.size());
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.removeLast());

        Iterator<Integer> i = deque.iterator();
        while (i.hasNext()) {
            StdOut.println(i.next());
        }

    }

}

