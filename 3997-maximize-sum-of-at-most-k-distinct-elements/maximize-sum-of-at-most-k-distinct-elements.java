class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        List<Integer> ls = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            if(ls.size() == 0 || ls.get(ls.size()-1) != nums[i]){
                ls.add(nums[i]);
                k--;
            }

            if(k == 0)break;
        }

        return ls.stream().mapToInt(i->i).toArray();
    }
}