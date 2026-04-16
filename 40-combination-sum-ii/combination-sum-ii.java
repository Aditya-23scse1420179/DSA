class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>current = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,current,ans);
        return ans ;
    }
    public void backtrack(int[]candidates,int target,int index,List<Integer>current,List<List<Integer>>ans){
        if(target==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(target<0||index>=candidates.length)return;
        current.add(candidates[index]);
        backtrack(candidates,target-candidates[index],index+1,current,ans);
        current.remove(current.size()-1);
        int idx=index+1;
        while(idx<candidates.length&&candidates[idx]==candidates[idx-1])idx++;
        backtrack(candidates,target,idx,current,ans);

    }
}