class Solution {
    public int totalFruit(int[] fruits) {
        int cnt = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();

        int left = 0;
        int right = 0;
        int n = fruits.length;

        int ans = 0;
        while(right < n){
            hash.put(fruits[right],hash.getOrDefault(fruits[right],0)+1);

            while(hash.size() > 2){
                hash.put(fruits[left],hash.get(fruits[left]) - 1);
                if(hash.get(fruits[left]) == 0){
                    hash.remove(fruits[left]);
                }
                left++;
            }

            ans = Math.max(ans,right - left + 1);

            right++;
        }

        return ans;
    }
}