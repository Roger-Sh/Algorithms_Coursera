package Week2.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackOfStrings_FixedCapacityArray {
    private String[] s;
    private int N = 0;      // current index

    public StackOfStrings_FixedCapacityArray(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        return s[--N];
    }

    public static void main(String[] args) {
        StackOfStrings_FixedCapacityArray stack = new StackOfStrings_FixedCapacityArray(10);

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
