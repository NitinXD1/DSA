class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        Queue<int[]> dq = new LinkedList<>();
        HashMap<Integer,Integer> hash = new HashMap<>();
        int cnt = 0;
        int n = arrivals.length;

        for(int i=0;i<n;i++){
            if(dq.size() > 0 && dq.peek()[1] + w - 1< i){
                int rem = dq.poll()[0];
                hash.put(rem,hash.get(rem)-1);
            }

            if(hash.containsKey(arrivals[i]) && hash.get(arrivals[i]) == m){
                cnt++;
                continue;
            }

            hash.put(arrivals[i],hash.getOrDefault(arrivals[i],0)+1);
            dq.offer(new int[]{arrivals[i],i});
        }

        return cnt;
    }
}