class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initially all cells are empty
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();

        backtrack(
            0,
            n,
            board,
            columns,
            diagonal1,
            diagonal2,
            result
        );

        return result;
    }

    public void backtrack(
        int row,
        int n,
        char[][] board,
        Set<Integer> columns,
        Set<Integer> diagonal1,
        Set<Integer> diagonal2,
        List<List<String>> result) {

        // All queens placed
        if (row == n) {

            List<String> solution = new ArrayList<>();

            for (char[] r : board) {
                solution.add(new String(r));
            }

            result.add(solution);
            return;
        }

        // Try every column
        for (int col = 0; col < n; col++) {

            // Check whether position is safe
            if (columns.contains(col) ||
                diagonal1.contains(row - col) ||
                diagonal2.contains(row + col)) {

                continue;
            }

            // Place queen
            board[row][col] = 'Q';

            columns.add(col);
            diagonal1.add(row - col);
            diagonal2.add(row + col);

            // Move to next row
            backtrack(
                row + 1,
                n,
                board,
                columns,
                diagonal1,
                diagonal2,
                result
            );

            // Backtrack
            board[row][col] = '.';

            columns.remove(col);
            diagonal1.remove(row - col);
            diagonal2.remove(row + col);
        }
    }
}