class Solution {
    public int climbStairs(int n) {
        int count = 0;
        if(n<=3)return n;
        else{
            int first = 2;
            int sec = 1;
            int temp = 0;
            for(int i =2;i<n;i++)
            {
                temp = first+sec;
                sec = first;
                first = temp;
            }
            return temp;
        }
    }
}