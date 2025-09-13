class Solution {
    public int smallestAbsent(int[] nums) {
        int total = 0;
        for(int i:nums)total += i;

        int n = nums.length;
        float avg = (float)total/n;

        int[] count = new int[102];

        for(int i:nums){
            if(i > 0)count[i] = 1;
        }

        for(int i=1;i<102;i++){
            if(i > avg && count[i] == 0)return i;
        }

        return -1;
    }
}