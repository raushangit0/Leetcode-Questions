class Solution {
    public String longestPalindrome(String s) {
        int start = 0,end = 1;
        if(s == null || s.length()< 2) return s;
        for(int i = 0 ; i<s.length() ; i++)
        {
            int lo = i-1;
            int hi = i;

            while((lo >=0 && hi < s.length() && (s.charAt(lo) == s.charAt(hi))))
            {
                if( hi-lo+1 > end)
                {
                    start = lo;
                    end = hi-lo+1;
                }
                lo--;
                hi++;
            }
            lo = i-1;
            hi = i+1;

            while((lo >=0 && hi < s.length() && (s.charAt(lo) == s.charAt(hi))))
            {
                if( hi-lo+1 > end)
                {
                    start = lo;
                    end = hi-lo+1;
                }
                lo--;
                hi++;
            }
        }
        return s.substring(start , start+end);
    }
}