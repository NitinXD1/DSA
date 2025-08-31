class Solution {
    public int[] findOrder(int numCourses, int[][] preq) {
       List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i:preq){
            adj.get(i[1]).add(i[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(!helper(i,vis,adj,pathVis,st))return new int[0];
            }
        }

        int[] ans = new int[numCourses];
        
        int i=0;

        while(!st.isEmpty()){
            ans[i] = st.pop();
            i++;
        }

        return ans;
    }

    public boolean helper(int index,boolean[] vis,List<List<Integer>> adj,boolean[] pathVis,Stack<Integer> st){
        vis[index] = true;
        pathVis[index] = true;
        

        for(int adjIndex : adj.get(index)){
            if(!vis[adjIndex]){
                if(!helper(adjIndex,vis,adj,pathVis,st))return false;
            }
            else if(pathVis[adjIndex])return false;
        }

        pathVis[index] = false;
        st.add(index);
        return true;
    }
}