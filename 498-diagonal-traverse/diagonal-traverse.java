class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] ans = new int[n * m];
        int index = 0;

        int r = 0;
        int c = 0;
        boolean up = true;

        while (index < n * m) {
            if (up) {
                while (r >= 0 && c < m) {
                    ans[index++] = mat[r][c];
                    r--;
                    c++;
                }

                if (c >= m) { 
                    c = m - 1;
                    r += 2;
                } else {
                    r = 0;
                }
                up = false;
            } else {
                while (r < n && c >= 0) {
                    ans[index++] = mat[r][c];
                    r++;
                    c--;
                }
                
                if (r >= n) {
                    r = n - 1;
                    c += 2;
                } else {
                    c = 0;
                }
                up = true;
            }
        }

        return ans;
    }
}
