class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int prefix [] = new int[n];
        int suffix [] = new int[n];
        int diff[] = new int[n];
        for(int i = 1 ; i<n ; i++)
        {
            prefix[i] = prefix[i-1]+nums[i-1];
        }
        for(int j = n-2 ; j>=0 ; j--)
        {
            suffix[j] = suffix[j+1]+nums[j+1];
        }
        for(int k = 0 ; k <n ; k++)
        {
            diff[k] = Math.abs(prefix[k]-suffix[k]);
        }
        return diff;
    }
}