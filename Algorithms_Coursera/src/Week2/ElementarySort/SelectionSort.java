package Week2.ElementarySort;

import edu.princeton.cs.algs4.StdOut;

/*
iterate array, in every iteration, find the min from the right side,
exchange it with current i,

cost:
    N^2/2 compares
    N exchanges
 */
public class SelectionSort {
    // selection sort,
    // iterate from left to right,
    //      find min on the right side of the current element,
    //      exchange min and current element
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
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

        SelectionSort.sort(days);

        for (int i = 0; i < days.length; i++) {
            StdOut.println(days[i].year + "_" + days[i].month + "_" + days[i].day);
        }
        StdOut.println("This array is sorted? " + SelectionSort.isSorted(days));
    }
}
