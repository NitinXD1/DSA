class Solution {
    public int minCost(String colors, int[] neededTime) {
        int total = 0;
        int n = neededTime.length;

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i-1)) {
                total += Math.min(neededTime[i], neededTime[i-1]);
                // keep the bigger one for future comparison
                neededTime[i] = Math.max(neededTime[i], neededTime[i-1]);
            }
        }

        return total;
    }
}