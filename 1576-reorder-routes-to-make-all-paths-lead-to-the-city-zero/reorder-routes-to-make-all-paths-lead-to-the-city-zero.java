class Solution {
    public int minReorder(int n, int[][] connections) {
        HashSet<String> st = new HashSet<>();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i:connections){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
            st.add(i[0] + " " + i[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] vis = new boolean[n];
        vis[0] = true;

        int cnt = 0;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int adjNode : adj.get(curr)){
                if(!vis[adjNode]){
                    String key = curr + " " + adjNode;
                    if(st.contains(key))cnt++;
                    q.offer(adjNode);
                    vis[adjNode] = true;
                }
            }
        }

        return cnt;
    }
}