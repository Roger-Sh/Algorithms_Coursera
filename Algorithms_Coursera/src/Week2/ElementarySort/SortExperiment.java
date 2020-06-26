package Week2.ElementarySort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.io.File;

public class SortExperiment {
    public static void main(String[] args) {
        // number sort
        String[] arg1 = {"10"};
        NumberSorter(arg1);

        // string sort
        String[] arg2 = {"word3.txt"};
        StringSorter(arg2);

        // file sort
        String[] arg3 = {"."};
        FileSorter(arg3);

    }

    public static void NumberSorter(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];

        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }

        Insertion.sort(a);
        for (int i = 0; i < N; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void StringSorter(String[] args) {
        // String sort
        // word3.txt
        String[] a = In.readStrings(args[0]);
        Insertion.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void FileSorter(String[] args) {
        File directory = new File(args[0]);
        File[] files = directory.listFiles();
        Insertion.sort(files);
        for (int i = 0; i < files.length; i++) {
            StdOut.println(files[i].getName());
        }
    }


}
