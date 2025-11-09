class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];

        HashMap<Integer,Integer> hash = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() < nums2[i]){
                st.pop();
            }

            hash.put(nums2[i],st.isEmpty() ? -1 : st.peek());
            st.push(nums2[i]);
        }

        for(int i=0;i<n;i++){
            ans[i] = hash.get(nums1[i]);
        }

        return ans;
    }
}