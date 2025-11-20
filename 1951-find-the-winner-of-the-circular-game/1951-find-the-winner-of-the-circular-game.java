class Solution {
    public int findTheWinner(int n, int k) {
        return josh(n,k)+1;
    }
    public int josh(int n , int k)
    {
        if(n==1)
        {
            return 0;
        }
        else
        {
            return(josh(n-1 , k)+ k)% n;
        }
    }
}