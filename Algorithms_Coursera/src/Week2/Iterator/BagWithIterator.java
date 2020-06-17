package Week2.Iterator;

/*
bag
    stack without pop, or queue without dequeue
 */

public class BagWithIterator<Item> implements Iterable<Item> {
    // init first Node = null
    private Node first = null;
    private int n = 0;  // size

    // private inner class Node, linked list
    private class Node {
        Item item;      // current item
        Node next;      // pointer to next Node
    }

    // insert a new item onto bag
    public void add(Item item) {
        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;

        this.n++;
    }

    // return the number of items in bag
    public int size() {
        return n;
    }

    // iterator for all items in bag
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    // inner class BagIterator
    private class BagIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        BagWithIterator<Integer> bag = new BagWithIterator<>();
        for (int i = 0; i < 5; i++) {
            bag.add(i * 5);
        }

        Iterator<Integer> i = bag.iterator();

        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }
}
