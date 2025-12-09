class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] memo = new Integer[n][amount + 1];
        return solveRec(n - 1, amount, coins, memo);
    }

    private int solveRec(int idx, int target, int[] coins, Integer[][] memo) {
        if (target == 0) return 1;       
        if (idx == 0) {                  
            return (target % coins[0] == 0) ? 1 : 0;
        }
        if (memo[idx][target] != null) return memo[idx][target];

        int notTake = solveRec(idx - 1, target, coins, memo);

        int take = 0;
        if (coins[idx] <= target) {
            take = solveRec(idx, target - coins[idx], coins, memo);
        }

        memo[idx][target] = notTake + take;
        return memo[idx][target];
    }
}
