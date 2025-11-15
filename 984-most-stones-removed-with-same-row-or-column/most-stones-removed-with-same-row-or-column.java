class Solution {
    class disjointSet{
        int[] parent;
        int[] size;

        public disjointSet(int n){
            parent = new int[n];
            size = new int[n];

            Arrays.fill(size,1);
            for(int i=0;i<n;i++)parent[i] = i;
        }

        public int findParent(int a){
            if(parent[a] == a)return a;
            return parent[a] = findParent(parent[a]);
        }

        public void union(int a,int b){
            int ulpA = findParent(a);
            int ulpB = findParent(b);

            if(ulpA == ulpB)return;

            int sizeA = size[ulpA];
            int sizeB = size[ulpB];

            if(sizeA > sizeB){
                parent[ulpB] = ulpA;
                size[ulpA] += sizeB;
            }
            else{
                parent[ulpA] = ulpB;
                size[ulpB] += sizeA;
            }
        }
    }

    public int removeStones(int[][] stones) {
        disjointSet ds = new disjointSet(20001);
        int n = stones.length;

        HashMap<Integer,Integer> hash = new HashMap<>();

        for(int[] i:stones){
            int r = i[0];
            int c = i[1] + 10001;

            ds.union(r,c);
            hash.put(r,1);
            hash.put(c,1);
        }

        int cnt = 0;
        for(int i:hash.keySet()){
            if(ds.findParent(i) == i)cnt++;
        }

        return n - cnt;
    }
}