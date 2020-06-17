import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {
    private double[] fractions;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        // check args
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Wrong size of grid or wrong trials!");
        }

        // monte-carlo
        fractions = new double[trials];
        for (int i = 0; i < trials; i++) {
            // init a new percolation instance
            Percolation p = new Percolation(n);

            // open sites until it percolates
            while (!p.percolates()) {
                // get a random index from [0, n*n-1]
                int ufIndex = StdRandom.uniform(n * n);

                // convert ufIndex to (row, col)
                int row = ufIndex / n + 1;
                int col = ufIndex % n + 1;

                // open site (row, col)
                p.open(row, col);
            }

            // calculate fraction of percolation
            fractions[i] = (double) p.numberOfOpenSites() / (double) (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(this.fractions);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(this.fractions);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(fractions.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(fractions.length);
    }

    // test client (see below)
    public static void main(String[] args) {
        // get n and trials from args
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(n, trials);
        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        System.out.println("95% confidence interval = ["
                                   + stats.confidenceLo()
                                   + ", "
                                   + stats.confidenceHi()
                                   + "]");
    }
}
