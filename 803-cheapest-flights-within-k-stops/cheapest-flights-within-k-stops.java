class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int[] i:flights)adj.get(i[0]).add(new int[]{i[1],i[2]});

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        dist[src] = 0;
        pq.offer(new int[]{src,0,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if(node == dst || stops == k+1)continue;

            for(int[] adjArr : adj.get(node)){
                int adjNode = adjArr[0];
                int adjCost = adjArr[1];
                
                int newCost = cost + adjCost;

                if(dist[adjNode] > newCost && stops + 1 <= k + 1){
                    dist[adjNode] = newCost;
                    pq.offer(new int[]{adjNode,newCost,stops+1});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}