class Solution {
    public int rob(int[] nums) {
        int prev2 = nums[0];
        if(nums.length<=1){
            return prev2;
        }
        int prev1 = Math.max(prev2,nums[1]);
        for(int i = 2;i<nums.length;i++)
        {
            int curr = Math.max(nums[i]+prev2,prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}