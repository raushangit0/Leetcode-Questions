class Solution {
    private int bs(int[]nums , int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(target>nums[mid]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        int index = bs(nums , target);
        if(index == -1)
        {
            answer[0] = -1;
            answer[1] = -1;
            return answer;
        }
        int hi = index;
        int lo = index;
        while(hi<nums.length && nums[hi] == target)
        {
            hi++;
        }
        while(lo>=0 && nums[lo]== target)
        {
            lo--;
        }
        answer[0] = lo+1;
        answer[1] = hi-1;
        return answer;
    }
}