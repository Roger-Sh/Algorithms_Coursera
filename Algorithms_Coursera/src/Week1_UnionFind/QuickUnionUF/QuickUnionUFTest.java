package Week1_UnionFind.QuickUnionUF;

public class QuickUnionUFTest {
    public static void main(String[] args) {
        // generate a instance
        QuickUnionUF test = new QuickUnionUF(20);

        // check p and q if they are connected
        System.out.println(test.connected(10, 15)); //false

        // union p and q
        test.union(10, 15);

        // check p and q if they are connected
        System.out.println(test.connected(10, 15)); // true
    }
}
