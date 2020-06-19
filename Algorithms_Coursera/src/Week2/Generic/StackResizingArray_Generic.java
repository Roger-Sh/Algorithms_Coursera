package Week2.Generic;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Linked-List
    1. every operation takes constant time in the worst case
    2. uses extra time and space to deal with the links
    3. stable time cost

Resizing-array, when out of capacity, double the size and copy the old data
    1. every operation takes constant amortized time
    2. less wasted space, but not stable

 */

public class StackResizingArray_Generic<Item> {
    // init array
    private Item[] s;
    private int N = 0;      // current index

    public StackResizingArray_Generic() {
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

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

    public Item pop() {
        return s[--N];
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        // double the size,
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public static void main(String[] args) {
        StackResizingArray_Generic stack = new StackResizingArray_Generic();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            // input: 1 2 3 4 5 6 7 8 9 0 1
            //System.out.println(s);
            // if "-", delete the last string, otherwise push it to stack
            if (s.equals("-") && !stack.isEmpty()) {
                StdOut.print(stack.pop());
            } else if (!s.equals("-")) {
                stack.push(s);
            }
        }

    }
}
