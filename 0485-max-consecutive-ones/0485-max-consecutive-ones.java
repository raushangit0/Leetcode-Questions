class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int window = 0;
        int n = nums.length;
        int ans = -1;
        for(int end = 0 ; end < n ; end++)
        {
            window += nums[end];
            while(end-start+1 != window)
            {
                window -= nums[start];
                start++;
            }
            ans = Math.max(ans , end-start+1);
        }
        return ans;
    }
}