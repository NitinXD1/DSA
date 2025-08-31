class Solution {
    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] box = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        initialize(board);
        helper(0, 0, board);
        display(board);
    }

    public void initialize(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    box[(i / 3) * 3 + j / 3][num] = true;
                }
            }
        }
    }

    public boolean helper(int r, int c, char[][] board) {
        if (r == 9) return true;

        int nextR = (c == 8) ? r + 1 : r;
        int nextC = (c == 8) ? 0 : c + 1;

        if (board[r][c] != '.') {
            return helper(nextR, nextC, board);
        }

        for (int num = 1; num <= 9; num++) {
            int boxIndex = (r / 3) * 3 + c / 3;

            if (!row[r][num] && !col[c][num] && !box[boxIndex][num]) {
                row[r][num] = col[c][num] = box[boxIndex][num] = true;
                board[r][c] = (char) ('0' + num);

                if (helper(nextR, nextC, board)) return true;

                row[r][num] = col[c][num] = box[boxIndex][num] = false;
                board[r][c] = '.';
            }
        }

        return false;
    }

    public void display(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
