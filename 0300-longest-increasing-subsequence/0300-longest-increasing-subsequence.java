class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer>temp = new ArrayList<>();
        temp.add(nums[0]);
        int n = nums.length;
        for(int i =0 ;i< n ;i++)
        {
            if(nums[i] > temp.get(temp.size()-1))
            {
                temp.add(nums[i]);
            }
            else
            {
                temp.set(lowerBound(temp,nums[i]),nums[i]);
            }
        }
        return temp.size();
    }
    public int lowerBound(ArrayList<Integer>temp , int target)
    {
        int low = 0;
        int hi = temp.size()-1;
        while(low <= hi)
        {
            int mid = low +(hi - low)/2;
            if(temp.get(mid) == target)
                return mid;
            else if(temp.get(mid)>target)
                hi = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
}