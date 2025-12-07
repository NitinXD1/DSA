class Solution {
    public int countOdds(int low, int high) {
        int gap = (high - low)/2;
        return low % 2 == 1 || high % 2 == 1 ? gap + 1 : gap;
    }
}