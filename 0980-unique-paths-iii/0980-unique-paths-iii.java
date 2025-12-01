class Solution {
    public int uniquePathsIII(int[][] arr) {
        int zeroCount = 0;
        int x = 0;
        int y =0;
        for (int i= 0; i<arr.length; i++) {
            for (int j =0; j<arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    zeroCount++;
                } else if (arr[i][j] == 1) {
                    x=i;
                    y=j;
                }
            }
        }
        return solve(arr, x, y, zeroCount, 0);
    }

    public int solve(int[][] arr, int i, int j, int zero, int countZero) {
       
        if (i<0 || i>=arr.length || j<0 || j >= arr[0].length || arr[i][j] == -1) {
            return 0;
        }
        if (arr[i][j] == 2) {
            return (zero == countZero - 1) ? 1 : 0;
        }
        arr[i][j] = -1;

        int totalPaths = solve(arr, i+ 1,j, zero,countZero +1) +  solve(arr, i-1, j, zero, countZero + 1) + 
                         solve(arr, i,j+1, zero, countZero +1) + 
                         solve(arr, i,j-1,zero, countZero + 1);  
    arr[i][j] = 0;

        return totalPaths;
    }
}