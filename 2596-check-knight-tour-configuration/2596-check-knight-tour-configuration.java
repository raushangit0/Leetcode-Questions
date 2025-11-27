class Solution {
    public boolean isSafe(int[][] grid, int row, int col, int num) {
        int n = grid.length;
        if (num == n * n - 1) return true;
        int i, j;
        // 2 up 1 right
        i = row - 2; j = col + 1;
        if (i >= 0 && j < n && grid[i][j] == num + 1) 
            return isSafe(grid, i, j, num + 1);
        // 2 up 1 left
        i = row - 2; j = col - 1;
        if (i >= 0 && j >= 0 && j < n && grid[i][j] == num + 1) 
            return isSafe(grid, i, j, num + 1);
        // 1 up 2 left
        i = row - 1; j = col - 2;
        if (i >= 0 && j >= 0 && j < n && grid[i][j] == num + 1) 
            return isSafe(grid, i, j, num + 1);
        // 1 down 2 left
        i = row + 1; j = col - 2;
        if (i < n && j >= 0 && j < n && grid[i][j] == num + 1) 
            return isSafe(grid, i, j, num + 1);
        // 1 up 2 right
        i = row - 1; j = col + 2;
        if (i >= 0 && j < n && grid[i][j] == num + 1) 
            return isSafe(grid, i, j, num + 1);
        // 1 down 2 right
        i = row + 1; j = col + 2;
        if (i < n && j < n && grid[i][j] == num + 1) 
            return isSafe(grid, i, j, num + 1);
        // 2 down 1 right
        i = row + 2; j = col + 1;
        if (i < n && j < n && grid[i][j] == num + 1) 
            return isSafe(grid, i, j, num + 1);
        // 2 down 1 left
        i = row + 2; j = col - 1;
        if (i < n && j >= 0 && j < n && grid[i][j] == num + 1) 
            return isSafe(grid, i, j, num + 1);
        return false;
    }
    
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        return isSafe(grid, 0, 0, 0);
    }
}