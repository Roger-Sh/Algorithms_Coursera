package Week2.Generic;

/*
stack of strings
LIFO

 */

public class StackOfStrings_LinkedList_Generic<Item> {

    // init first Node = null
    private Node first = null;
    private int n;  // size

    // private inner class Node, linked list
    private class Node {
        Item item;    // current item
        Node next;      // pointer to next Node
    }

    // insert a new string onto stack
    public void push(Item item) {
        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;

        this.n++;
    }


    // remove and return the string most recently added
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

    public static void main(String[] args) {

        StackOfStrings_LinkedList_Generic<Phone> stack = new StackOfStrings_LinkedList_Generic();
        System.out.println("is empty? " + stack.isEmpty());

        Phone p1 = new Phone("Apple", 5999, "Black");
        Phone p2 = new Phone("Apple", 5999, "White");
        Phone p3 = new Phone("Xiaomi", 3499, "Black");

        stack.push(p1);
        System.out.println("is empty? " + stack.isEmpty());
        stack.push(p2);
        stack.push(p3);

        Phone p;
        while (!stack.isEmpty()) {
            p = stack.pop();
            p.show();
        }

    }
}

class Phone {
    private String mark;
    private double price;
    private String color;

    public Phone() {
        this.mark = "default mark";
        this.price = 0;
        this.color = "default color";
    }

    public Phone(String mark, double price, String color) {
        this.mark = mark;
        this.price = price;
        this.color = color;
    }

    public void show() {
        System.out.println("Mark: " + this.mark);
        System.out.println("Price: " + this.price);
        System.out.println("Color: " + this.color);
    }

}
