class Solution {
    public boolean canFinish(int numCourses, int[][] preq) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i:preq){
            adj.get(i[1]).add(i[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(!helper(i,vis,adj,pathVis))return false;
            }
        }

        return true;
    }

    public boolean helper(int index,boolean[] vis,List<List<Integer>> adj,boolean[] pathVis){
        vis[index] = true;
        pathVis[index] = true;

        for(int adjIndex : adj.get(index)){
            if(!vis[adjIndex]){
                if(!helper(adjIndex,vis,adj,pathVis))return false;
            }
            else if(pathVis[adjIndex])return false;
        }

        pathVis[index] = false;
        return true;
    }
}
