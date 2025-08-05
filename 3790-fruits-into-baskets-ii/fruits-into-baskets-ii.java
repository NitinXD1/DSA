class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        for(int i:fruits){
            for(int j=0;j<n;j++){
                if(baskets[j] >= i){
                    baskets[j] = 0;
                    break;
                }
            }
        }

        int cnt = 0;

        for(int i:baskets){
            if(i != 0)cnt++;;
        }

        return cnt;
    }
}