class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        int n = graph.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                helper(i,vis,pathVis,adj);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(vis[i] && !pathVis[i]){
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean helper(int node,boolean[] vis,boolean[] pathVis,List<List<Integer>> adj){
        vis[node] = true;
        pathVis[node] = true;

        for(int adjNode : adj.get(node)){
            if(!vis[adjNode]){
                if(!helper(adjNode,vis,pathVis,adj))return false;
            }
            else if(pathVis[adjNode])return false;
        }

        pathVis[node] = false;

        return true;
    }
}