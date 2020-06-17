package Week2.Iterators;

public class StackWithIterator_ResizingArray<Item> implements Iterable<Item> {

    /*
                Stack_ResizingArray
     */

    // init array
    private Item[] s;
    private int N = 0;      // current index

    // constructor
    public StackWithIterator_ResizingArray() {
        s = (Item[]) new Object[1];
    }

    // determine if empty
    public boolean isEmpty() {
        return N == 0;
    }

    // push an element
    public void push(Item item) {
        // if more item then array length, double the size
        // a lot of waste capacity?
        if (N == s.length) {
            System.out.println("doubling the size");
            resize(2 * s.length);
            System.out.println("current size: " + s.length);
        }

        s[N++] = item;
    }

    // remove an element and return it
    public Item pop() {
        return s[--N];
    }

    // double the size of array if there is no enough space
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        // double the size,
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    /*
                iterator
     */

    // abstract method from interface Iterable, generate an iterator
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // inner class ReverseArrayIterator to implement interface iterator
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        // determine if there is element left or not
        public boolean hasNext() {
            return i > 0;
        }

        // return the next element (reverse)
        public Item next() {
            return s[--i];
        }

        //public void remove();
    }

    public static void main(String[] args) {
        StackWithIterator_ResizingArray<Integer> stackInt = new StackWithIterator_ResizingArray<>();
        for (int i = 0; i < 10; i++) {
            stackInt.push(i * 2);
        }

        Iterator<Integer> i = stackInt.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

}
