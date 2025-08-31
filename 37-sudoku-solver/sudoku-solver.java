class Solution {
    HashMap<Integer, Set<Integer>> row = new HashMap<>();
    HashMap<Integer, Set<Integer>> col = new HashMap<>();
    HashMap<Integer, Set<Integer>> box = new HashMap<>();

    public void solveSudoku(char[][] board) {
        initialize(board);
        helper2(0, 0, board);
        display(board);
    }

    public void initialize(char[][] board) {
        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            box.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row.get(i).add(num);
                    col.get(j).add(num);
                    box.get((i / 3) * 3 + j / 3).add(num);
                }
            }
        }
    }

    public boolean helper2(int r, int c, char[][] board) {
        if (r == 9) return true;

        int nextR = (c == 8) ? r + 1 : r;
        int nextC = (c == 8) ? 0 : c + 1;

        if (board[r][c] != '.') {
            return helper2(nextR, nextC, board);
        }

        for (int num = 1; num <= 9; num++) {
            int boxIndex = (r / 3) * 3 + c / 3;

            if (!row.get(r).contains(num) && !col.get(c).contains(num) && !box.get(boxIndex).contains(num)) {
                row.get(r).add(num);
                col.get(c).add(num);
                box.get(boxIndex).add(num);

                board[r][c] = (char) ('0' + num);

                if (helper2(nextR, nextC, board)) return true;

                row.get(r).remove(num);
                col.get(c).remove(num);
                box.get(boxIndex).remove(num);
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
