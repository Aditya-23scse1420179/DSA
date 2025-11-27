class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(board, 0, ans);
        return ans;
    }
    public void backtrack(char[][] board, int row, List<List<String>> ans) {
        int n = board.length;
        // if all queens placed
        if (row == n) {
            ans.add(convert(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, ans);
                board[row][col] = '.';
            }
        }
    }
    public boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        // left upper diagonal
        int i = row, j = col;
        while (i >= 0 && j >= 0)
            if (board[i--][j--] == 'Q') return false;

        // right upper diagonal
        i = row; 
        j = col;
        while (i >= 0 && j < n)
            if (board[i--][j++] == 'Q') return false;

        return true;
    }

    private List<String> convert(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}
