class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int cnt = numBottles;
        int empty = numBottles;

        while(empty >= numExchange){
            int newBottles = empty/numExchange;
            empty -= Math.floor((double)empty/numExchange) * numExchange;
            empty += newBottles;
            cnt += newBottles;
        }

        return cnt;
    }
}