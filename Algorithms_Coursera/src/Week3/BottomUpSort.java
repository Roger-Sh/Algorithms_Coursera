package Week3;

import Week2.ElementarySort.Date;
import edu.princeton.cs.algs4.StdOut;

public class BottomUpSort {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];

        for (int sz = 1; sz < N; sz = sz + sz) {            // sz = 1, 2, 4, 8, 16
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
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
        BottomUpSort.sort(days);

        for (int i = 0; i < days.length; i++) {
            StdOut.println(days[i].year + "_" + days[i].month + "_" + days[i].day);
        }
        StdOut.println("This array is sorted? " + BottomUpSort.isSorted(days, 0, days.length - 1));
    }
}
