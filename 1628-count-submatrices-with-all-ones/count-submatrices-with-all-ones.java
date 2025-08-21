class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] height = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1)
                    height[i][j] = (i == 0 ? 0 : height[i-1][j]) + 1;
            }
            ans += countRow(height[i]);
        }
        return ans;
    }

    private int countRow(int[] h) {
        int m = h.length, ans = 0;
        for (int i = 0; i < m; i++) {
            int min = h[i];
            for (int j = i; j >= 0 && min > 0; j--) {
                min = Math.min(min, h[j]);
                ans += min;
            }
        }
        return ans;
    }
}
