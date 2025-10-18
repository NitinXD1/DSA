class Solution {
    public boolean canFinish(int n, int[][] prereq) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i:prereq){
            adj.get(i[1]).add(i[0]);
        }

        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];
        boolean[] currVis = new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(!helper(i,adj,st,vis,currVis))return false;
            }
        }

        return st.size() == n;
    }

    public boolean helper(int node,List<List<Integer>> adj,Stack<Integer> st,boolean[] vis,boolean[] currVis){
        vis[node] = true;
        currVis[node] = true;
        
        for(int adjNode : adj.get(node)){
            if(!vis[adjNode]){
                if(!helper(adjNode,adj,st,vis,currVis))return false;
            }
            else if(currVis[adjNode]){
                return false;
            }
        }

        st.add(node);
        currVis[node] = false;

        return true;
    }
}