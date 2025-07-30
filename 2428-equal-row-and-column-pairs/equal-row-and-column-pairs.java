class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> hash = new HashMap<>();
        int m = grid[0].length;
        int n = grid.length;

        for(int[] i:grid){
            String key = Arrays.toString(i);
            hash.put(key, hash.getOrDefault(key, 0) + 1);
        }

        int cnt = 0;

        for(int i=0;i<m;i++){
            int[] col = new int[m];
            for(int j=0;j<n;j++){
                col[j] = grid[j][i];
            }
            String colKey = Arrays.toString(col);
            cnt += hash.getOrDefault(colKey, 0);
        }

        return cnt;
    }
}