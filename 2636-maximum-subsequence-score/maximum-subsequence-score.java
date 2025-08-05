class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        List<int[]> ls = new ArrayList<>();

        int n = nums1.length;

        for(int i=0;i<n;i++){
            ls.add(new int[]{nums1[i],nums2[i]});
        }

        Collections.sort(ls,(a,b) -> Integer.compare(b[1],a[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long ans = 0 , sumS = 0;

        for(int[] i:ls){
            pq.add(i[0]);
            sumS = sumS + i[0];

            if(pq.size() > k){
                sumS -= pq.poll();
            }
            if(pq.size() == k){
                ans = Math.max(ans,(sumS * i[1]));
            }
        }

        return ans;
    }
}