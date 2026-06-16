class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int left = nums[0];
        int right = nums[n - 1];
        for (int i = 0; i < n; i++) {
            left = i % k == 0 ? nums[i] : Math.max(left, nums[i]);
            if (i >= k - 1) {
                ans[i - k + 1] = left;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            right = i % k == k - 1 ? nums[i] : Math.max(right, nums[i]);
            if (i <= n - k) {
                ans[i] = Math.max(ans[i], right);
            }
        }
        return ans;
    }
}