class Solution {
    public int[] findOrder(int n, int[][] preq) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i:preq){
            adj.get(i[1]).add(i[0]);
            inDegree[i[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n];
        int index = 0;

        for(int i=0;i<n;i++){
            if(inDegree[i] == 0)q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            ans[index++] = node;

            for(int adjIndex : adj.get(node)){
                if(--inDegree[adjIndex] == 0){
                    q.offer(adjIndex);
                }
            }
        }

        return index == n ? ans : new int[0];
    }
}