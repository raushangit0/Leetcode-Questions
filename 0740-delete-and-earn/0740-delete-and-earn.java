class Solution {
    public int solve(int i , int[] freq , int []dp)
    {
        if(i >= freq.length)return 0;
        if(dp[i] != -1)return dp[i];
        int notTake = solve(i+1 , freq , dp);
        int take = freq[i] + solve(i+2 , freq , dp);

        return dp[i] = Math.max(take , notTake);
    }
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int freq[] = new int [max+1];
        for(int i = 0 ; i < n ; i++)
        {
            freq[nums[i]] += nums[i];
        } 
        int []dp = new int [freq.length];
        Arrays.fill(dp , -1);
        return solve(0 , freq , dp);
    }
}