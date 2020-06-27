package Week2.ElementarySort;

/*
how to make a class comparable?

use interface Comparable to implement a function compareTo()
so that every data type can be comparable
 */


public class Date implements Comparable<Date> {
    public final int month, day, year;

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
}

