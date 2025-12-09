class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        Integer[][] dp = new Integer[nums.length][target + 1];
        return solveRec(nums.length - 1, target, nums, dp);
    }

    private boolean solveRec(int idx, int target, int[] nums, Integer[][] dp) {
        if (target == 0) return true;
        if (idx == 0) return nums[0] == target;
        if (dp[idx][target] != null) return dp[idx][target] == 1;

        boolean notTake = solveRec(idx - 1, target, nums, dp);
        boolean take = false;
        if (nums[idx] <= target) {
            take = solveRec(idx - 1, target - nums[idx], nums, dp);
        }

        dp[idx][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }
}
