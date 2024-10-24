package Daily;

import java.util.Arrays;

public class convert1Dto2D {
    public static void main(String[] args) {
        int [] age = {1,2,3,4};
        int [][] ans = construct2DArray(age,2,2);
        for (int [] arr : ans) {
            System.out.println(Arrays.toString(arr));
        }
    }

    static int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m*n) return new int[0][0];
        int [][] ans = new int[m][n];
        for(int i=0;i<original.length;i++){
            int row = i/n;
            int col = i%n;
            ans[row][col] = original[i];
        }
        return ans;
    }

    //Another Way
    static int[][] construct2DArrayWAY2(int[] original, int m, int n) {
        if(original.length != m*n) return new int[0][0];
        int [][] ans = new int[m][n];
        int k = 0;
        for (int i = 0; i < ans.length ; i++) {
            for (int j = 0; j <ans[0].length ; j++) {
                ans[i][j] = original[k++];
            }
        }
        return ans;
    }
}
