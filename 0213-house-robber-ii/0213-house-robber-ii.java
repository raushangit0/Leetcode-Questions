class Solution {
    static int solve(int nums[])
    {
        int prev2 = nums[0];
        if(nums.length<=1){
            return prev2;
        }
        int prev1 = Math.max(prev2,nums[1]);
        for(int i =2;i<nums.length-1;i++)
        {
            int curr = Math.max(nums[i]+prev2,prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    static int solve1(int nums[])
    {
        if(nums.length<2){
            return nums[0];
        }
        int prev2 = nums[1];
        if(nums.length<=2){
            return prev2;
        }
        int prev1 = Math.max(prev2,nums[2]);
        for(int i = 3;i<nums.length;i++)
        {
            int curr = Math.max(nums[i]+prev2,prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        return Math.max(solve(nums),solve1(nums));
    }
}