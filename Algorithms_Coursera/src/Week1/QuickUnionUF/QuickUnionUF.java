package Week1.QuickUnionUF;

public class QuickUnionUF {
    private int[] id;
    private int[] sz;   // size of tree rooted at i

    // constructor
    // init cost: N
    public QuickUnionUF(int N) {
        // init object array
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

        // init tree size rooted at i
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    // find root of i by chasing parent pointers until reach root
    private int root(int i) {
        // if i == id[i], return i, otherwise continue set the next level of parent until root
        while (i != id[i]) {
            // compress the tree
            //while looking for root，you can easily set the parent of i to its grandparent to compress the tree
            id[i] = id[id[i]];

            i = id[i];
        }
        return i;
    }

    // check if p and q have same root
    // find cost: N
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // change root of p to point to root of q
    // set the root of p to root of q
    // union cost: N^+, including cost of finding roots
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) {
            return;
        }

        // weighted tree
        // point the small tree to big tree, use sz[i] to find the tree size rooted at i
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
