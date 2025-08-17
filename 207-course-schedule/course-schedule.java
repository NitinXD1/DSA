class Solution {
    public boolean canFinish(int n, int[][] preq) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i:preq){
            adj.get(i[1]).add(i[0]);
        }

        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(!dfs(i,adj,vis,pathVis))return false;
            }
        }

        return true;
    }

    public boolean dfs(int node,List<List<Integer>> adj,boolean[] vis,boolean[] pathVis){
        vis[node] = true;
        pathVis[node] = true;

        for(int adjNode : adj.get(node)){
            if(!vis[adjNode]){
                if(!dfs(adjNode,adj,vis,pathVis))return false;
            }
            else if(pathVis[adjNode])return false;
        }

        pathVis[node] = false;

        return true;
    }
}