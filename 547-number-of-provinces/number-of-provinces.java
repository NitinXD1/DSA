class Dsu{
    private int[] size;
    private int[] parent;
    int cnt;

    Dsu(int n){
        size = new int[n];
        parent = new int[n];
        cnt = n;

        Arrays.fill(size,1);

        for(int i=0;i<n;i++){
            parent[i] = i;
        }
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
            size[ulpB] += sizeA;
        }
        else{
            parent[ulpB] = ulpA;
            size[ulpA] += sizeB;
        }

        cnt--;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Dsu dsu = new Dsu(n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1)dsu.union(i,j);
            }
        }

        return dsu.cnt;
    }
}