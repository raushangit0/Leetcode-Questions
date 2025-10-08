class Solution {
    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        Map <Character , Integer > map = new HashMap <>();
        if(sl!=tl){
        return false;
        }
        for(int i=0; i <sl;i++){
            Character sc = s.charAt(i);
            Character st = t.charAt(i);
            map.put(sc,map.getOrDefault(sc,0)+1);
            map.put(st,map.getOrDefault(st,0)-1);
        }
        for(int i : map.values()){
            if(i!=0)
            {
                return false;
            }
        }
         return true;
    }
}