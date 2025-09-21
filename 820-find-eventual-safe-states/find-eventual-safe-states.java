class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        int n = graph.length;
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        int[] inDegree = new int[n];

        for(int i=0;i<n;i++){
            for(int j:graph[i]){
                adj.get(j).add(i);
                inDegree[i]++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int adjNode : adj.get(node)){
                if(--inDegree[adjNode] == 0){
                    q.offer(adjNode);
                }
            }

            ans.add(node);
        }

        Collections.sort(ans);

        return ans;
    }
}