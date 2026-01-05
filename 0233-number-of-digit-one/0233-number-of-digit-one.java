class Solution {

    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        Long[][][] dp = new Long[s.length()][2][s.length()];
        return (int) solve(s, 0, 1, 0, dp);
    }

    private long solve(String s, int idx, int tight, int countOne, Long[][][] dp) {

        if (idx == s.length()) {
            return countOne;
        }

        if (dp[idx][tight][countOne] != null) {
            return dp[idx][tight][countOne];
        }

        int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;
        long res = 0;

        for (int dig = 0; dig <= ub; dig++) {
            int newTight = (tight == 1 && dig == ub) ? 1 : 0;
            int newCount = countOne + (dig == 1 ? 1 : 0);
            res += solve(s, idx + 1, newTight, newCount, dp);
        }

        return dp[idx][tight][countOne] = res;
    }
}
