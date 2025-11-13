class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for(int i:nums)st.add(i);

        int ans = 0;
        for(int i:st){
            if(!st.contains(i-1)){
                int x = 1;
                while(st.contains(i+x)){
                    x++;
                }

                ans = Math.max(ans,x);
            }
        }

        return ans;
    }
}