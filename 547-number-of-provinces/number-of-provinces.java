class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] vis = new boolean[n];

        int cnt = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,adj);
                cnt++;
            }
        }

        return cnt;
    }

    public void dfs(int node,boolean[] vis,List<List<Integer>> adj){
        vis[node] = true;

        for(int adjNode : adj.get(node)){
            if(!vis[adjNode])dfs(adjNode,vis,adj);
        }
    }
}