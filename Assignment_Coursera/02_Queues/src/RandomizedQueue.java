/*
random queue

 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    // private variable
    private int N;          // number of items in queue
    private Item[] items;   // use dynamic array to store items

    private class RandomIterator implements Iterator<Item> {
        // private variable
        private int[] index;
        private int current;

        // constructor
        public RandomIterator() {
            // init index
            index = new int[N];
            for (int i = 0; i < N; i++) {
                index[i] = i;
            }

            // randomize the index
            for (int i = 0; i < N; i++) {
                int random = StdRandom.uniform(N - i);
                int temp = index[random];
                index[random] = index[N - 1 - i];
                index[N - 1 - i] = temp;
            }

            // init current index
            current = N - 1;

        }

        public boolean hasNext() {
            return current >= 0;
        }

        public Item next() {
            if (current < 0) {
                throw new NoSuchElementException();
            }
            return items[index[current--]];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        N = 0;
        items = (Item[]) new Object[1]; // convert Object[] to Item[], initialize it with 1 element
    }

    // is queue empty
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items
    public int size() {
        return N;
    }

    // add item
    public void enqueue(Item item) {
        // check arg
        if (item == null) {
            throw new IllegalArgumentException();
        }

        // check length of array
        if (N == items.length) {
            resize(2 * items.length);
        }

        items[N++] = item;
    }

    // return and return a random item
    public Item dequeue() {
        // check if empty
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (N == 1) {
            N--;
            return items[0];
        } else {
            int random = StdRandom.uniform(N);
            Item item = items[random];
            items[random] = items[N - 1];
            items[N - 1] = null;
            N--;

            // if current number of item < length/4, resize the length to half
            if (N > 0 && N == items.length / 4) {
                resize(items.length / 2);
            }

            return item;
        }
    }

    // return a random item, but do not remove it
    public Item sample() {
        // check if empty
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (N == 1) {
            return items[0];
        } else {
            int random = StdRandom.uniform(N);
            return items[random];
        }
    }

    // resize array with double length
    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];

        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }

        items = temp;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    // unit test
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        StdOut.println(rq.isEmpty());


        for (int i = 0; i < 5; i++) {
            rq.enqueue(i);
        }
        StdOut.println(rq.size());

        for (int i = 0; i < 10; i++) {
            StdOut.println(rq.sample());
        }

        StdOut.println(rq.dequeue());

        Iterator<Integer> i = rq.iterator();
        while (i.hasNext()) {
            StdOut.println(i.next());
        }

    }
}

