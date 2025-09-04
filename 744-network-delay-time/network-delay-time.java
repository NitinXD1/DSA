class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());

        for(int[] i:times)adj.get(i[0]).add(new int[]{i[1],i[2]});

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));

        q.offer(new int[]{k,0});

        dist[k] = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];

            if(cost > dist[node])continue;

            for(int[] adjArr : adj.get(node)){
                int adjNode = adjArr[0];
                int adjCost = adjArr[1];

                int newCost = cost + adjCost;

                if(newCost < dist[adjNode]){
                    dist[adjNode] = newCost;
                    q.offer(new int[]{adjNode,newCost});
                }
            }
        }

        int max = 0;

        for(int i=1;i<=n;i++){
            max = Math.max(max,dist[i]);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }
}