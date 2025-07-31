class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        
        dfs(0,rooms,vis);

        for(boolean b : vis){
            if(!b)return false;
        }

        return true;
    }

    public void dfs(int node,List<List<Integer>> rooms,boolean[] vis){
        if(vis[node])return;

        vis[node] = true;

        for(int key : rooms.get(node)){
            if(!vis[key]){
                dfs(key,rooms,vis);
            }
        }

        return;
    }
}