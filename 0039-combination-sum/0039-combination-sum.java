class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates , 0 , target , ans , new ArrayList<>());
        return ans;
    }
    public static void helper(int [] candidates , int i , int target , List<List<Integer>> ans , List<Integer>res)
    {
        int n = candidates.length;
        if(target == 0)
        {
            ans.add(new ArrayList<>(res));
            return;
        }
        if(target <0 || i == n)
        {
            return;
        }
        res.add(candidates[i]);
        helper(candidates , i , target-candidates[i],ans , res);
        res.remove(res.size()-1);
        helper(candidates,i+1,target,ans,res);
    }
}