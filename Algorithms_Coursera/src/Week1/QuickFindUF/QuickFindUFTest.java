package Week1.QuickFindUF;

public class QuickFindUFTest {
    public static void main(String[] args) {

        QuickFindUF test = new QuickFindUF(10);

        System.out.println(test.connected(0, 1));    // false

        // union entry 0 and 1
        test.union(0, 1);

        System.out.println(test.connected(0, 1));    // true
    }
}
