package Week2.Stack;

/*
 * 利用2个栈实现简单的运算操作
 * Dijkstra双栈算法
 *
 * 1、将操作数压入操作数栈；
 * 2、将运算符压入运算符栈；
 * 3、忽略左括号；
 * 4、在遇到右括号时，弹出一个运算符，弹出所需数量的操作数，并将运算符和操作数的运算结果压入操作数栈
 *
 * 输入的运算每个操作必须用括号
 */

import Week2.Generic.StackLinkedList_Generic;

public class twoStackDijkstra {
    public static void main(String[] args) {
        // every operator should be in a pair of parenthesis
        String s = "(1+((2+3)*(4*5)))";
        twoStack(s);
    }

    public static void twoStack(String str) {
        StackLinkedList_Generic<String> ops = new StackLinkedList_Generic<>();  // stack for operation
        StackLinkedList_Generic<Double> vals = new StackLinkedList_Generic<>(); // stack for value

        for (int i = 0; i < str.length(); i++) {
            // iterative get character
            String s = (char) str.getBytes()[i] + "";

            /*
                    read char
                    if operator, put it onto stack ops.
                    if left parenthesis, do nothing
                    if right parenthesis, get the last op and last two value,
                        determine the result, put it back to stack vals
             */

            // left parenthesis, do nothing
            if (s.equals("(")) {
            }   // do nothing

            // operator, put in stack ops
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);

                // right parenthesis, calculate
            else if (s.equals(")")) {
                String op = ops.pop();  // get last operator from stack ops
                double v = vals.pop();  // get last value from stack vals

                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                vals.push(v);
            }

            // values, put in stack vals
            else {
                vals.push(Double.parseDouble(s));
            }
        }

        System.out.println("Result: " + vals.pop());
    }
}
