class Solution {
    public int magicalString(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int [] s = new int[n + 2];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;
        int count = 1;
        int i = 2, j = 3;
        int num = 1;
        while(j < n)
        {
            int times = s[i];
            for(int k = 0; k < times && j < n; k++)
            {
                s[j] = num;
                if(num == 1)
                    count++;
                j++;
            }
            num = 3 - num;
            i++;
        }
        return count;
    }
}