class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        vis[0] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int key : rooms.get(curr)){
                if(!vis[key]){
                    vis[key] = true;
                    q.offer(key);
                }
            }
        }

        for(boolean b : vis){
            if(!b)return false;
        }

        return true;
    }
}