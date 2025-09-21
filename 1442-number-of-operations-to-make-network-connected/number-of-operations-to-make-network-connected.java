class Solution {
    class disjoint{
        int[] parent;
        int[] size;
        int cnt;

        public disjoint(int n){
            size = new int[n];
            parent = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
            }
            Arrays.fill(size,1);
            cnt = n;
        }

        public int findParent(int a){
            if(parent[a] == a)return a;
            return parent[a] = findParent(parent[a]);
        }

        public void union(int a,int b){
            int ulpA = findParent(a);
            int ulpB = findParent(b);
            int sizeA = size[ulpA];
            int sizeB = size[ulpB];

            if(ulpA == ulpB)return;
            
            if(sizeA < sizeB){
                parent[ulpA] = ulpB;
                size[ulpB] += size[ulpA];
            }
            else{
                parent[ulpB] = ulpA;
                size[ulpA] += size[ulpB];
            }

            cnt--;
        }
    }


    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        disjoint du = new disjoint(n);

        for(int[] i:connections){
            du.union(i[0],i[1]);
        }

        System.out.println(Arrays.toString(du.parent));
        System.out.println(Arrays.toString(du.size));

        return du.cnt-1;
    }
}