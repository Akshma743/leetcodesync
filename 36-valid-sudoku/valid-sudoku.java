class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                // Empty cell
                if (board[i][j] == '.') {
                    continue;
                }

                int digit = board[i][j] - '1';

                int boxNumber = (i / 3) * 3 + (j / 3);

                // Duplicate check
                if (row[i][digit] ||
                    col[j][digit] ||
                    box[boxNumber][digit]) {

                    return false;
                }

                // Mark as present
                row[i][digit] = true;
                col[j][digit] = true;
                box[boxNumber][digit] = true;
            }
        }

        return true;
    }
}