class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int[] i:prereq)adj.get(i[1]).add(i[0]);

        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[numCourses];
        boolean[] currVis = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(!helper(i,adj,st,vis,currVis))return false;
            }
        }

        return true;
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

        currVis[node] = false;
        st.push(node);

        return true;
    }
}