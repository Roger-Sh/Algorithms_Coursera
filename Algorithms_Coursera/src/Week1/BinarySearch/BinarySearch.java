package Week1.BinarySearch;

/*
Binary search
 compare with the middle of high boundary and low boundary
 */

public class BinarySearch {
    public static int binarySearch(int[] a, int key) {
        int lo = 0, hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;     // key == a[mid]
            }
        }

        return -1;  // if lo > hi
    }

    public static void main(String[] args) {
        int[] arrayInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index_3 = binarySearch(arrayInt, 3);
        System.out.println("Index of 3 is " + index_3);
    }
}

