class Solution {
    public int[] findOrder(int n, int[][] preq) {
       List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i:preq){
            adj.get(i[1]).add(i[0]);
        }

        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(!dfs(i,adj,vis,pathVis,st))return new int[0];
            }
        }

        int[] ans = new int[n];
        int i=0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }

        return ans;
    }

    public boolean dfs(int node,List<List<Integer>> adj,boolean[] vis,boolean[] pathVis,Stack<Integer> st){
        vis[node] = true;
        pathVis[node] = true;

        for(int adjNode : adj.get(node)){
            if(!vis[adjNode]){
                if(!dfs(adjNode,adj,vis,pathVis,st))return false;
            }
            else if(pathVis[adjNode])return false;
        }

        pathVis[node] = false;

        st.push(node);

        return true;
    }
}