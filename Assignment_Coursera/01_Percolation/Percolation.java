import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;                      // grid size n x n
    private boolean[][] gridOpened;     // grid open with 1, closed with 0

    private int topUFIndex;             // union-find index for top site
    private int bottomUFIndex;          // union-find index for bottom site

    private WeightedQuickUnionUF uf;    // union-find structur for sites, with top and bottom
    private WeightedQuickUnionUF ufBackflow;   // union-find structur for sites, just with top

    private int openedCount;            // counter for opened sites

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        // check arg
        validateArgs(n <= 0);
        this.n = n;

        // init grid
        gridOpened = new boolean[this.n][this.n];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                gridOpened[i][j] = false;
            }
        }

        // init top site and bottom site
        // extra site for top and bottom
        topUFIndex = n * n;            // index of top is n*n + 1
        bottomUFIndex = n * n + 1;     // index of bottom is n*n + 2

        // WeightedQuickUnionUF for sites
        uf = new WeightedQuickUnionUF(n * n + 2);           // with top and bottom
        ufBackflow = new WeightedQuickUnionUF(n * n + 1);    // with only top

        // counter for opened sites
        openedCount = 0;
    }

    // open site and union with its neighbor or top/bottom site
    public void open(int row, int col) {
        // index range [1,n] to [0, n-1]
        row--;
        col--;

        // check args row and col
        validateArgs(row < 0 || row >= this.n || col < 0 || col >= this.n);

        // open a site (row, col), and union its opened neighbor
        if (!gridOpened[row][col]) {
            // set site(row, col) to open
            gridOpened[row][col] = true;

            // convert (row, col) to union-find index
            int ufIndex = row * this.n + col;

            // if row == 0, union with top
            if (row == 0) {
                uf.union(ufIndex, topUFIndex);
                ufBackflow.union(ufIndex, topUFIndex);
            }

            // if row == n-1, union with bottom
            if (row == n - 1) {
                uf.union(ufIndex, bottomUFIndex);
            }

            // union up opened site
            if (row - 1 >= 0) {
                if (gridOpened[row - 1][col]) {
                    int upUFIndex = (row - 1) * this.n + col;
                    uf.union(ufIndex, upUFIndex);
                    ufBackflow.union(ufIndex, upUFIndex);
                }
            }

            // union down opened site
            if (row + 1 <= n - 1) {
                if (gridOpened[row + 1][col]) {
                    int downUFIndex = (row + 1) * this.n + col;
                    uf.union(ufIndex, downUFIndex);
                    ufBackflow.union(ufIndex, downUFIndex);
                }
            }

            // union left opened site
            if (col - 1 >= 0) {
                if (gridOpened[row][col - 1]) {
                    int leftUFIndex = row * this.n + (col - 1);
                    uf.union(ufIndex, leftUFIndex);
                    ufBackflow.union(ufIndex, leftUFIndex);
                }
            }

            // union right opened site
            if (col + 1 <= n - 1) {
                if (gridOpened[row][col + 1]) {
                    int leftUFIndex = row * this.n + (col + 1);
                    uf.union(ufIndex, leftUFIndex);
                    ufBackflow.union(ufIndex, leftUFIndex);
                }
            }

            // counter for opened sites
            openedCount++;
        }


    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        // index range [1,n] to [0, n-1]
        row--;
        col--;

        // check arg row and col
        validateArgs(row < 0 || row >= n || col < 0 || col >= n);

        return gridOpened[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        boolean isFull;

        // index range [1,n] to [0, n-1]
        row--;
        col--;

        // check arg row and col
        validateArgs(row < 0 || row >= n || col < 0 || col >= n);

        // convert (row, col) to UF index
        int ufIndex = row * this.n + col;

        // check if (row, col) connected with top
        // here to solve the backflow problem, don't use the UF with top and bottom, just with top
        // isFull = ufBackflow.connected(ufIndex, topUFIndex);
        isFull = ufBackflow.find(ufIndex) == ufBackflow.find(topUFIndex);
        return isFull;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return this.openedCount;
    }

    // does the system percolate?
    public boolean percolates() {
        // boolean isPercolates = uf.connected(topUFIndex, bottomUFIndex);
        // use find() == find() to replace connected()
        boolean isPercolates = uf.find(topUFIndex) == uf.find(bottomUFIndex);
        return isPercolates;
    }

    private void validateArgs(boolean invalid) {
        if (invalid) {
            throw new IllegalArgumentException("Wrong size of grid!");
        }
    }

    public static void main(String[] args) {

    }
}
