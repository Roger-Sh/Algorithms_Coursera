package Week3;

import Week2.ElementarySort.Date;
import edu.princeton.cs.algs4.StdOut;

/*
Merge Sort
Idea:
    1. use insertion sort to sort the half array
    2. merge the two half array
 */

public class MergeSort {
    // insertion sort,
    // iterate from left to right,
    //      exchange current element i with left element, till there is no bigger element on the left
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {           // i move from left to right
            for (int j = i; j > lo; j--) {       // j move from i to left
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);          // exchange the current element with its left bigger element
                else break;                     // till there is only smaller elements on the left
            }
        }
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // precondition, half sorted
        assert isSorted(a, lo, mid);        // precondition a[lo...mid] sorted
        assert isSorted(a, mid + 1, hi);    // precondition a[mid+1...hi] sorted

        // copy
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        // merge
        int i = lo, j = mid + 1;
        for (int k = lo; k <= mid + 1; k++) {
            if (i > mid) {                      // i finished
                a[k] = aux[j++];
            } else if (j > hi) {                // j finished
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {  // aux[j] < aux[i]
                a[k] = aux[j++];
            } else {                            // aux[j] < aux[i]
                a[k] = aux[i++];
            }
        }

        // check if a sorted
        assert isSorted(a, lo, hi);
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

    // check if array[lo,..., hi] is sorted
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
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
        Date day4 = new Date(12, 01, 1995);
        Date day5 = new Date(5, 28, 1993);
        Date day6 = new Date(6, 26, 2020);
        Date[] days = {day1, day2, day3, day4, day5, day6};

        // split the array in two half array
        int N = days.length;    // length
        int mid = N / 2 - 1;    // middle position
        int lo = 0;             // start position
        int hi = N - 1;         // end position

        // sort the half array
        sort(days, lo, mid);
        sort(days, mid + 1, hi);

        for (int i = 0; i < days.length; i++) {
            StdOut.println(days[i].year + "_" + days[i].month + "_" + days[i].day);
        }
        StdOut.println("This array is half sorted? " + MergeSort.isSorted(days, lo, hi));

        // merge the half sorted array
        Date[] days_aux = new Date[N];
        MergeSort.merge(days, days_aux, lo, mid, hi);

        for (int i = 0; i < days.length; i++) {
            StdOut.println(days[i].year + "_" + days[i].month + "_" + days[i].day);
        }
        StdOut.println("This array is sorted? " + MergeSort.isSorted(days, lo, hi));
    }
}
