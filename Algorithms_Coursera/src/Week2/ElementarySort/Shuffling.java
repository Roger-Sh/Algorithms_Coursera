package Week2.ElementarySort;

/*
Shuffle idea
    1. give every item a random real number, sort items according to the real number
    2. iterate from left to right, exchange current i with random r  from the lefr side
 */

import edu.princeton.cs.algs4.StdRandom;

public class Shuffling {

    // randomly shuffle the array
    public static void shuffle(Object[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(i + 1);
            exch(a, i, r);
        }
    }

    // exchange the two object in array a
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        String[] str = {"a", "b", "c", "d", "e", "f", "g"};
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }

        shuffle(str);

        System.out.println("after shuffling");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
