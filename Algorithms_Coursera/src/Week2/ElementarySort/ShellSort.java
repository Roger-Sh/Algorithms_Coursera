package Week2.ElementarySort;

/*
Idea: Move entries more than one position at a time by h-sorting the array

cost:
    worst case numbers of compares by shell sort with 3x+1 increments is N^(3/2)
 */

import edu.princeton.cs.algs4.StdOut;

public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;

        // h-sorting by 3x+1 increment sequence, like: 13, 4, 1
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;    // 1, 4, 13, 40, 121, 364... 3x+1 increment sequence
        }

        // for every h, partially sort by h-sorting
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {       // insertion sort
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;        // move to next increment
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

        ShellSort.sort(days);

        for (int i = 0; i < days.length; i++) {
            StdOut.println(days[i].year + "_" + days[i].month + "_" + days[i].day);
        }
        StdOut.println("This array is sorted? " + ShellSort.isSorted(days));
    }
}
