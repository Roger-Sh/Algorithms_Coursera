package Week1.QuickFindUF;

public class QuickFindUF {
    private int[] id;

    // constructor,
    // init cost: N
    public QuickFindUF(int N) {
        // generate a integer array with entries equal to its index
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // determine if entry of p and q are equal,
    // find cost: 1
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // union the p and q, set entry same as p entry to the entry of q,
    // union cost: N,
    // too expensive, it takes N^2 array accesses to process a sequence of N union commands on N objects
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}
