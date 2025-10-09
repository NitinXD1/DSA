class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            hash.put(nums[i],i);
        }

        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(hash.containsKey(-(nums[i]+nums[j]))){
                    int index = hash.get(-(nums[i]+nums[j]));
                    if(index == i || index == j)continue;
                    List<Integer> arr = Arrays.asList(nums[i],nums[j],-(nums[i]+nums[j]));
                    Collections.sort(arr);
                    st.add(arr);
                }
            }
        }

        return new ArrayList<>(st);
    }
}