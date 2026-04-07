class Solution {
    public int uniquePaths(int m, int n) {
        Integer dp[][] = new Integer[m][n];
        return helper(0,0,m,n,dp);
    }
    private int helper(int i ,int j , int m , int n , Integer[][]dp)
    {
        if(i == m-1 || j == n-1)
        {
            dp[i][j] = 1;
            return 1;
        }
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int right = helper(i , j+1 , m , n , dp);
        int down = helper(i+1 , j , m , n, dp);
        return dp[i][j] = right + down ;
    }
}