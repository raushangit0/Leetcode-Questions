class Solution {
     static int solve(int arr[],int i,int j,int target){
        if (i>j){
            return -1;
        }
        int mid=i+(j-i)/2;
        if (arr[mid]==target){
            return mid;
        }
        if(arr[mid]<target){
            return solve(arr,mid+1,j,target);
        }else{
            return solve(arr,i,mid-1,target);
        }
    }
    public boolean searchMatrix(int[][] arr, int target) {
         for (int i=0;i<arr.length;i++){
            if (arr[i][0]<=target && arr[i][arr[0].length-1]>=target){
               if(solve(arr[i],0,arr[i].length-1,target)!=-1){
                   return true;
                }
            }
        }
        return false;
    }
}