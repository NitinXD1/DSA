class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        int n = graph.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int adjNode : adj.get(node)){
                if(--inDegree[adjNode] == 0)q.offer(adjNode);
            }

        }

        Collections.sort(ans);

        return ans;
    }
}