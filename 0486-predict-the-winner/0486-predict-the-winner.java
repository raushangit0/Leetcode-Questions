class Solution {
    public boolean predictTheWinner(int[] nums) {
     return helper(nums,0,nums.length-1) >=0;   
    }
    public int helper(int [] nums ,int l ,int r)
    {
        if(l==r)
            return nums[l];
        int leftPick = nums[l] - helper(nums,l+1,r);
        int rightPick = nums[r] -helper(nums , l , r-1);
        return Math.max(leftPick , rightPick);
    }
}