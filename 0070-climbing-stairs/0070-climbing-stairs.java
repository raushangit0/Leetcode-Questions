class Solution {
    public int climbStairs(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int prev_2 =1;
        int prev_1=2;
        int curr = 0;
        for(int i =3;i<=n;i++)
        {
            curr =prev_1+prev_2;
            prev_2=prev_1;
            prev_1=curr;
        }
        return prev_1;
    }
}