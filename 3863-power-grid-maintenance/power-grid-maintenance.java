import java.util.*;

class Dsu {
    int[] parent;
    int[] size;
    HashMap<Integer, PriorityQueue<Integer>> hash;
    HashSet<Integer> off;

    public Dsu(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        hash = new HashMap<>();
        off = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(i);
            hash.put(i, pq);
        }
    }

    int findParent(int a) {
        if (parent[a] == a) return a;
        return parent[a] = findParent(parent[a]);
    }

    void union(int a, int b) {
        int ulpA = findParent(a), ulpB = findParent(b);
        if (ulpA == ulpB) return;

        int sizeA = size[ulpA];
        int sizeB = size[ulpB];

        if(sizeA < sizeB){
            int temp = ulpA;
            ulpA = ulpB;
            ulpB = temp;
        }
        
        size[ulpA] += ulpB;
        parent[ulpB] = ulpA;

        PriorityQueue<Integer> x = hash.get(ulpA);
        PriorityQueue<Integer> y = hash.get(ulpB);

        x.addAll(y);
        hash.remove(ulpB);
        hash.put(ulpA,x);
    }

    void offNode(int x) {
        off.add(x);
    }

    int query(int x) {
        if (!off.contains(x)) return x;
        int p = findParent(x);
        PriorityQueue<Integer> pq = hash.get(p);
        while (!pq.isEmpty() && off.contains(pq.peek())) pq.poll();
        if (pq.isEmpty()) return -1;
        return pq.peek();
    }
}

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Dsu dsu = new Dsu(c);
        for (int[] e : connections) dsu.union(e[0], e[1]);
        
        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) ans.add(dsu.query(q[1]));
            else dsu.offNode(q[1]);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
