class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int x : nums)
        {
            map.put(x , map.getOrDefault(x,0)+1);
        }
        ArrayList<Integer> li = new ArrayList<>(map.keySet());
        Collections.sort(li ,(a,b)-> map.get(b)- map.get(a));
        int [] result = new int[k];
        for(int i = 0 ; i< k; i++)
        {
            result[i] = li.get(i);
        }
        return result;
    }
}