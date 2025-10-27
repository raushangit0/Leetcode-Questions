class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = nums.length -1;
        if(n == 1)return nums[0];
        if(n == 2)return Math.min(nums[0],nums[1]);
        else
        {
            while(start <= end)
            {
                int mid = start+(end - start)/2;

                if(nums[mid] > nums[mid+1])return nums[mid+1];
                if(nums[mid-1] > nums[mid])return nums[mid];
                if(nums[0] < nums[n-1])return nums[0];

                if(nums[start] < nums[mid])
                {
                    start = mid+1;
                }
                else
                {
                    end = mid -1;
                }
            }
            return 0;
        }
    }
}