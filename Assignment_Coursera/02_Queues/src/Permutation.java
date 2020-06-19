import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        // get number k
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<String>();

        // get string from StdIn
        while (!StdIn.isEmpty()) {  // ctrl + D end input
            rq.enqueue(StdIn.readString());
            System.out.println(rq.size());
        }

        // print k string from queue randomly
        while (!rq.isEmpty()) {
            StdOut.print(rq.dequeue());
        }
    }
}
