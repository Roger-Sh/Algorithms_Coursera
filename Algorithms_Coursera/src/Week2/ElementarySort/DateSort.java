package Week2.ElementarySort;

import edu.princeton.cs.algs4.StdOut;

public class DateSort {
    public static void main(String[] args) {
        Date day1 = new Date(12, 01, 1995);
        Date day2 = new Date(5, 28, 1993);
        StdOut.println(less(day1, day2));

        Date day3 = new Date(6, 26, 2020);
        Date[] days = {day1, day2, day3};
        DateSort.sort(days);

        for (int i = 0; i < days.length; i++) {
            StdOut.println(days[i].year + "_" + days[i].month + "_" + days[i].day);
        }
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
            //assert isSorted(a, 0, i);
        }
        assert isSorted(a);
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
}
