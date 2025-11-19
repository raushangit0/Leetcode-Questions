class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        return helper(matrix, target, 0, m * n - 1, m, n);
    }
    
    private boolean helper(int[][] matrix, int target, int start, int end, int m, int n) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        int row = mid / n;
        int col = mid % n;
        if (matrix[row][col] == target) {
            return true;
        } else if (matrix[row][col] < target) {
            return helper(matrix, target, mid + 1, end, m, n);
        } else {
            return helper(matrix, target, start, mid - 1, m, n);
        }
    }
}