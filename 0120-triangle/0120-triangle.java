class Solution {
    int n;
    static Integer dp[][];
    public int minimumTotal(List<List<Integer>> t) {
        n = t.size();
        dp = new Integer[n+1][n+1];
        return solveRec(0,0,n,t);
    }
    public int solveRec(int i , int j ,int n , List<List<Integer>>t)
    {
        if(i == n-1)
        {
            return t.get(i).get(j);
        }
        if(dp[i][j] != null)return dp[i][j];
        int down = t.get(i).get(j) + solveRec(i+1 , j , n, t);
        int dig = t.get(i).get(j) + solveRec(i+1 , j+1 , n , t);
        return dp[i][j] = Math.min(down , dig);
    }
}