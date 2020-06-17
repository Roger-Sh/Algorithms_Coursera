package Week2.Stack;

/*
stack of strings
LIFO

 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackOfStrings_LinkedList {

    // init first Node = null
    private Node first = null;

    // private inner class Node, linked list
    private class Node {
        String item;    // current item
        Node next;      // pointer to next Node
    }

    // insert a new string onto stack
    public void push(String item) {
        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }


    // remove and return the string most recently added
    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    // is the stack empty?
    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {

        StackOfStrings_LinkedList stack = new StackOfStrings_LinkedList();

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
