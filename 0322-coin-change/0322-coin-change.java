class Solution {
    public int coinChange(int[] coins, int amount) {
       int n = coins.length;
       Integer[][] dp = new Integer[n][amount+1];
       int ans = solverec(n-1 , amount , coins,dp);
       return (ans >= (int)1e9)?-1 :ans;
    }
    public int solverec(int idx , int amount , int[]coins , Integer[][]dp)
    {
        if(amount == 0)return 0;
        if(idx == 0)
        {
            return(amount % coins[0] ==0) ? amount/coins[0] : (int)1e9;
            // {
            //     return amount/coins[0];
            // }
            // else
            // {
            //     return (int)1e9;
            // }
        }
        if(dp[idx][amount]!= null)
        {
            return dp[idx][amount];
        }
        int notTake = solverec(idx-1 , amount , coins , dp);
        int take = (int)1e9;
        if(coins[idx] <= amount)
        {
            take = 1+ solverec(idx , amount-coins[idx],coins , dp);
        }
        return dp[idx][amount] = Math.min(take , notTake);
    }
}