class Solution {

    int count = 0;

    public int totalNQueens(int n) {

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();

        backtrack(
            0,
            n,
            columns,
            diagonal1,
            diagonal2
        );

        return count;
    }

    public void backtrack(
        int row,
        int n,
        Set<Integer> columns,
        Set<Integer> diagonal1,
        Set<Integer> diagonal2) {

        // All queens successfully placed
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            // Check column and diagonals
            if (columns.contains(col) ||
                diagonal1.contains(row - col) ||
                diagonal2.contains(row + col)) {

                continue;
            }

            // Place queen
            columns.add(col);
            diagonal1.add(row - col);
            diagonal2.add(row + col);

            // Next row
            backtrack(
                row + 1,
                n,
                columns,
                diagonal1,
                diagonal2
            );

            // Backtrack
            columns.remove(col);
            diagonal1.remove(row - col);
            diagonal2.remove(row + col);
        }
    }
}