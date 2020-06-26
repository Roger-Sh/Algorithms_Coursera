package Week2.ElementarySort;

import edu.princeton.cs.algs4.StdOut;

/*
use interface Comparable to implement a function compareTo()
so that every data type can be comparable
 */


public class Date implements Comparable<Date> {
    private final int month, day, year;

    public Date(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    @Override
    public int compareTo(Date that) {
        if (this.year < that.year) return -1;
        if (this.year > that.year) return +1;
        if (this.month < that.month) return -1;
        if (this.month > that.month) return +1;
        if (this.day < that.day) return -1;
        if (this.day > that.day) return +1;
        return 0;
    }

    public static void main(String[] args) {
        Date day1 = new Date(12, 01, 1995);
        Date day2 = new Date(5, 28, 1993);

        StdOut.println(less(day1, day2));
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}

