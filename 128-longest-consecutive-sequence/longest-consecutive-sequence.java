class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) pq.offer(i);

        int ans = 1;
        int cnt = 1;
        int prev = pq.poll();

        while (!pq.isEmpty()) {
            int val = pq.poll();
            if (val == prev) continue;

            if (val == prev + 1) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
            prev = val;
        }

        ans = Math.max(ans, cnt);
        return ans;
    }
}
