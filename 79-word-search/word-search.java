class Solution {
    public boolean exist(char[][] board, String word) {
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean dfs(char[][] board, String word,
                         int i, int j, int index) {
        
        // Word completely found
        if (index == word.length()) {
            return true;
        }

        // Invalid position or character mismatch
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            board[i][j] != word.charAt(index)) {
            
            return false;
        }

        // Mark current cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Search in 4 directions
        boolean found =
            dfs(board, word, i + 1, j, index + 1) ||  // Down
            dfs(board, word, i - 1, j, index + 1) ||  // Up
            dfs(board, word, i, j + 1, index + 1) ||  // Right
            dfs(board, word, i, j - 1, index + 1);     // Left

        // Backtrack
        board[i][j] = temp;

        return found;
    }
}