class Solution {
    public double maxAverageRatio(int[][] classes, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            double first = ((double)(a[0]+1)/(a[1]+1)) - (a[0]/(double)a[1]);
            double second = ((double)(b[0]+1)/(b[1]+1)) - (b[0]/(double)b[1]);

            return Double.compare(second,first);
        });

        for(int[] i:classes)pq.offer(i);

        for(int i=0;i<n;i++){
            int[] curr = pq.poll();

            curr[0]++;
            curr[1]++;

            pq.offer(curr);
        }

        double total = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            total += ((double)curr[0]/curr[1]);
        }

        return total/classes.length;
    }
}