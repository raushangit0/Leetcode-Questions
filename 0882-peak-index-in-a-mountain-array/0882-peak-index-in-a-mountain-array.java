class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       int n = arr.length;
        int start = 1;
        int end = n-2;
        int mid = 0;

        while(start <= end )
        {
            mid = start+(end - start)/2;

            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1])return mid;
            if(arr[mid-1] < arr[mid])start = mid+1;
            else{
                end = mid-1;
            }
        }
        return mid;
    }
}