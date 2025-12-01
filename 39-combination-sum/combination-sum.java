class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[]arr,int target,int index,List<Integer> path,List<List<Integer>> ans) {
        if (target ==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || index == arr.length) return;
        path.add(arr[index]);
        backtrack(arr,target -arr[index],index, path,ans);
        path.remove(path.size()-1);
        backtrack(arr,target,index+ 1,path, ans);
    }
}
