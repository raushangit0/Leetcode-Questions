class Solution {
    public char findKthBit(int n, int k) {
        if(n==1)
        return '0';
        int length = (1<<n)-2; //2^n-1
        int mid = length/2+1;
        if(mid == k){
            return '1';
        }
        if(mid >k){
            return findKthBit(n-1 , k);
        }
        else
        {
            char ch = findKthBit(n-1 , 2*mid-k);
            if(ch =='0')
            return '1';
            else 
            return '0';
        }

    }
}