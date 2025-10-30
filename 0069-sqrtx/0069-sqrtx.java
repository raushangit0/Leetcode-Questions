class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1)return x;

        int start =1 , end =x/2 ,ans = 0;

        while(start <= end)
        {
            int mid = start+(end-start)/2;

            long sqr = (long)mid*mid;

            if(sqr == x)
            {
                return mid;
            }
            else if(sqr < x)
            {
                ans = mid;
                start = mid+1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return ans;
    }
}