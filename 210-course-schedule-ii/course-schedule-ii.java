class Solution {
    public int[] findOrder(int n, int[][] preq) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];

        for(int[] i:preq){
            adj.get(i[1]).add(i[0]);
            inDegree[i[0]]++;
        }


        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(inDegree[i] == 0)q.offer(i);
        }
        
        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int adjNode : adj.get(node)){
                if(--inDegree[adjNode] == 0){
                    q.offer(adjNode);
                }
            }
        }

        if(ans.size() != n)return new int[0];

        return ans.stream().mapToInt(i -> i).toArray();        
    }

}