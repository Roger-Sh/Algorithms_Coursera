package Week3;

import Week2.ElementarySort.Date;
import edu.princeton.cs.algs4.StdOut;

/*
Merge Sort
Idea:
    recursive do the following process
    1. split the array
    2. sort the half array
    3. merge the two half array

Cost:
    N*lgN compares
    6*N*lgN array access

 */

public class MergeSort {
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return; // end of the sort

        // sort the half array
        int mid = lo + (hi - lo) / 2;

        // recursive sort the half array and merge them
        sort(a, aux, lo, mid);      // switch aux and a to save a little time
        sort(a, aux, mid + 1, hi);

        // check if this two half array are already sorted
        if (!less(a[mid + 1], a[mid])) return;  // if a[mid+1] > a[mid], there is no need to merge them

        // merge the sorted half array
        merge(a, aux, lo, mid, hi);
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
        for (int k = lo; k <= hi; k++) {
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
        Date day7 = new Date(12, 01, 1953);
        Date day8 = new Date(5, 28, 1968);
        Date day9 = new Date(6, 26, 2021);
        Date[] days = {day1, day2, day3, day4, day5, day6, day7, day8, day9};

        // merge sort
        MergeSort.sort(days);

        for (int i = 0; i < days.length; i++) {
            StdOut.println(days[i].year + "_" + days[i].month + "_" + days[i].day);
        }
        StdOut.println("This array is sorted? " + MergeSort.isSorted(days, 0, days.length - 1));
    }
}
