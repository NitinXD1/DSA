class Solution {
    public int totalFruit(int[] nums) {
        int left = 0;
        int right = 0;

        int n = nums.length;
        int max = 0;
        int cnt = 0;

        int[] hash = new int[100001];

        while(right < n){
            if(hash[nums[right]] == 0)cnt++;
            hash[nums[right]]++;

            while(cnt > 2){
                hash[nums[left]]--;
                if(hash[nums[left]] == 0)cnt--;
                left++;
            }

            if(cnt <= 2){
                max = Math.max(right - left + 1,max);
            }

            right++;
        }

        return max;
    }
}