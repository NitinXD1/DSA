import java.util.*;

class Dsu {
    int[] parent;
    int[] size;
    HashMap<Integer, PriorityQueue<Integer>> pqMap;
    HashSet<Integer> offline;

    public Dsu(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        pqMap = new HashMap<>();
        offline = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(i);
            pqMap.put(i, pq);
        }
    }

    int findParent(int a) {
        if (parent[a] == a) return a;
        return parent[a] = findParent(parent[a]);
    }

    void union(int a, int b) {
        int pa = findParent(a), pb = findParent(b);
        if (pa == pb) return;

        if (size[pa] < size[pb]) {
            int tmp = pa;
            pa = pb;
            pb = tmp;
        }

        parent[pb] = pa;
        size[pa] += size[pb];

        PriorityQueue<Integer> pqA = pqMap.get(pa);
        PriorityQueue<Integer> pqB = pqMap.get(pb);
        pqA.addAll(pqB);
        pqMap.put(pa, pqA);
        pqMap.remove(pb);
    }

    void goOffline(int x) {
        offline.add(x);
    }

    int query(int x) {
        if (!offline.contains(x)) return x;

        int p = findParent(x);
        PriorityQueue<Integer> pq = pqMap.get(p);

        while (!pq.isEmpty() && offline.contains(pq.peek())) {
            pq.poll(); // lazy remove
        }

        if (pq.isEmpty()) return -1;
        return pq.peek();
    }
}

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Dsu dsu = new Dsu(c);

        for (int[] edge : connections) {
            dsu.union(edge[0], edge[1]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) { // query
                ans.add(dsu.query(q[1]));
            } else if (q[0] == 2) { // take offline
                dsu.goOffline(q[1]);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
