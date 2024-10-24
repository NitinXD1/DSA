package GoodQuestions;

import java.util.ArrayList;
import java.util.List;

public class NQueensPrint {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        String[][] board = new String[n][n];
        // Initialize the board with "."
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        nQueens(res, board, 0);
        return res;
    }

    static void nQueens(List<List<String>> res, String[][] arr, int row) {
        if (row == arr.length) {
            addSet(res, arr);
            return;
        }

        for (int col = 0; col < arr.length; col++) {
            if (isSafe(arr, row, col)) {
                arr[row][col] = "Q";
                nQueens(res, arr, row + 1);
                arr[row][col] = ".";
            }
        }
    }

    static boolean isSafe(String[][] arr, int row, int col) {
        // Vertically checking
        for (int i = 0; i < row; i++) {
            if ("Q".equals(arr[i][col])) {
                return false;
            }
        }

        // Diagonal checks (top-left to bottom-right)
        for (int i=0;i <= Math.min(row,col) ;i++) {
            if ("Q".equals(arr[row-i][col-i])) {
                return false;
            }
        }

        // Diagonal checks (top-right to bottom-left)
        for (int i = 0; i <= Math.min(row, arr.length-col-1); i++) {
            if ("Q".equals(arr[row-i][col+i])) {
                return false;
            }
        }

        return true;
    }

    static void addSet(List<List<String>> res, String[][] arr) {
        List<String> currentSolution = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[i][j]);
            }
            currentSolution.add(sb.toString());
        }
        res.add(currentSolution);
    }

}
