class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] count = new int[value];
        
        for (int x : nums) {
            int mod = ((x % value) + value) % value;
            count[mod]++;
        }

        int m = 0;
        while (true) {
            int mod = m % value;
            if (count[mod] == 0) return m;
            count[mod]--;
            m++;
        }
    }
}
