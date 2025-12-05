import java.util.*;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; // CORRECT: use '.' instead of 'x'
            }
        }
        backtrack(board, 0, n, result);
        return result;
    }

    private void backtrack(char[][] board, int row, int n, List<List<String>> result) {
        if (row == n) {
            result.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, n, result);
                board[row][col] = '.'; // Reset to '.'
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false; // Column
            if (board[row][i] == 'Q') return false; // Row (redundant but safe)
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false; // Left diagonal
        }
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false; // Right diagonal
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}