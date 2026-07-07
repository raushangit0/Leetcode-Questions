class Solution {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray())
            {
                if(c!='0')
                {
                    sb.append(c);
                }
            }
            if(sb.length()==0)return 0;
            long x= Integer.parseInt(sb.toString());

            long sum =0;
            long temp =x;
            while(temp > 0)
                {
                    sum+= temp%10;
                    temp /= 10;
                }
            return x*sum;
    }
}