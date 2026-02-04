class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
        {
            return false;
        }
       HashMap<Character, Integer> s1Count = new HashMap<>();
       for(int i = 0 ; i<s1.length() ; i++)
       {
        char curr= s1.charAt(i);
        s1Count.put(curr , s1Count.getOrDefault(curr , 0)+1);
       }
       HashMap<Character, Integer> s2Count = new HashMap<>();
       int start = 0;
       int end = 0;
       int k  =s1.length();
       while(end < s2.length())
       {
        char curr = s2.charAt(end);
        s2Count.put(curr , s2Count.getOrDefault(curr , 0)+1);
       if(end >= k-1)
       {
        if(s1Count.equals(s2Count)) return true;
        char temp = s2.charAt(start);
        s2Count.put(temp , s2Count.getOrDefault(temp,0)-1);
        if(s2Count.get(temp)==0) s2Count.remove(temp);
        start++;
       }
         end++;
       }
       return false;
    }
}