class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected[0].length;
        boolean[] vis = new boolean[n+1];

        int cnt = 0;

        for(int i=1;i<=n;i++){
            if(!vis[i]){
                cnt++;
                dfs(i-1,isConnected,vis);
            }
        }

        return cnt;
    }

    public void dfs(int node,int[][] isConnected,boolean[] vis){
        vis[node+1] = true;

        for(int i=0;i<isConnected[node].length;i++){
            if(!vis[i+1] && isConnected[node][i] == 1){
                dfs(i,isConnected,vis);
            }
        }
    }
}