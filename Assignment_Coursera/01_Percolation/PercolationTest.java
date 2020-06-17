/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class PercolationTest {
    public static void main(String[] args) {
        Percolation p1 = new Percolation(3);

        p1.open(1, 1);
        System.out.println(p1.percolates());
        p1.open(2, 1);
        System.out.println(p1.percolates());
        p1.open(2, 2);
        System.out.println(p1.percolates());
        p1.open(3, 2);
        System.out.println(p1.percolates());
        System.out.println(p1.numberOfOpenSites());
    }
    

}
