package Week2.Generic;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackOfStrings_FixedCapacityArray_Generic<Item> {
    // init array refer
    private Item[] s;
    private int N = 0;      // current index

    public StackOfStrings_FixedCapacityArray_Generic(int capacity) {
        s = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        s[N++] = item;
    }

    public Item pop() {
        return s[--N];
    }

    public static void main(String[] args) {
        StackOfStrings_FixedCapacityArray_Generic stack = new StackOfStrings_FixedCapacityArray_Generic(10);

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

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
