class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length()-1;

        while(s.charAt(n)== ' ')
            n--;

        int count = 0;

        while(n>=0 && s.charAt(n)!=' ')
        {
            count++;
            n--;
        }
        return count;
    }
}