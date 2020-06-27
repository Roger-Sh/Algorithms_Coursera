package Week2.ElementarySort;

import edu.princeton.cs.algs4.StdOut;

/*
cost:
    N^2/4 compares
    N^2/4 exchanges

 */


public class InsertionSort {
    // insertion sort,
    // iterate from left to right,
    //      exchange current element i with left element, till there is no bigger element on the left
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {           // i move from left to right
            for (int j = i; j > 0; j--) {   // j move from i to left
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);          // exchange the current element with its left bigger element
                else break;                     // till there is only smaller elements on the left
            }
        }
    }

    // compare two comparable object
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange the two object in array a
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // check if array is sorted
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Date day1 = new Date(12, 01, 1995);
        Date day2 = new Date(5, 28, 1993);
        Date day3 = new Date(6, 26, 2020);
        Date[] days = {day1, day2, day3};

        InsertionSort.sort(days);

        for (int i = 0; i < days.length; i++) {
            StdOut.println(days[i].year + "_" + days[i].month + "_" + days[i].day);
        }
        StdOut.println("This array is sorted? " + InsertionSort.isSorted(days));
    }
}
