package Week2.Iterators;

/*
Iterable
    has a mehtod that returns an iterator

Iterator
    has method hasNext() and next()

 */


public class StackWithIterator<Item> implements Iterable<Item> {

    /*
            stack with linked list
     */

    // init first Node = null
    private Node first = null;
    private int n;  // size

    // private inner class Node, linked list
    private class Node {
        Item item;      // current item
        Node next;      // pointer to next Node
    }

    // insert a new item onto stack
    public void push(Item item) {
        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;

        this.n++;
    }

    // remove and return the item most recently added
    public Item pop() {
        Item item = null;
        if (!isEmpty()) {
            item = first.item;
            first = first.next;
            this.n--;
        } else {    // empty
            System.out.println("there is no item left");
        }

        return item;
    }

    // is the stack empty?
    public boolean isEmpty() {
        return first == null;
    }

    /*
            Iterator
     */

    // abstract method from Iterable interface, make this stack structure iterable
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // inner class to implement interface Iterator
    private class ListIterator implements Iterator<Item> {
        // init current node
        private Node current = first;

        // determine if there is node left or not
        public boolean hasNext() {
            return current != null;
        }

        // return the current next and point to the next item
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        //public void remove();

    }

    public static void main(String[] args) {
        StackWithIterator<Integer> stackInt = new StackWithIterator<>();

        for (int i = 0; i < 10; i++) {
            stackInt.push(i * 10);
        }

        Iterator<Integer> s = stackInt.iterator();
        while (s.hasNext()) {
            System.out.println(s.next());
        }

    }
}




/*
        this two interface should be implemented to make a structure iterable
 */

// generate a iterator
interface Iterable<Item> {
    Iterator<Item> iterator();
}


// iterator contains hasNext() and next()
interface Iterator<Item> {
    boolean hasNext();

    Item next();

    // void remove();
}
