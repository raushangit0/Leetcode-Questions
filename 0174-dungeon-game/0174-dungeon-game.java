class Solution {
    static int[][] dp = new int[201][201];

    public int solve(int[][] dungeon, int i, int j) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (i == m - 1 && j == n - 1) {
            return dungeon[i][j] >= 0 ? 1 : 1 - dungeon[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = solve(dungeon, i + 1, j);
        int right = solve(dungeon, i, j + 1);

        int need = Math.min(down, right) - dungeon[i][j];

        return dp[i][j] = (need <= 0) ? 1 : need;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        for (int i = 0; i < 201; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(dungeon, 0, 0);
    }
}