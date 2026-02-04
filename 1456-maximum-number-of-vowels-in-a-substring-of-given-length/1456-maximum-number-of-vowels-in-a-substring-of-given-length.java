class Solution {
    public boolean isVowel(char c)
    {
        if(c == 'a'|| c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
    public int maxVowels(String s, int k) {
       int n = s.length();
       int start = 0;
       int end = 0;
       int count = 0;
       int maxCount = 0;
       while(end < n)
       {
        char c = s.charAt(end);
        if(isVowel(c)) count++;
        if(end >= k-1)
        {
            maxCount = Math.max(count , maxCount);
            char exclude = s.charAt(start);
            if(isVowel(exclude))count--;
            start++;
        }
        end++;
       } 
       return maxCount;
    }
}