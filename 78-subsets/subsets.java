class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        helper(list,ans,nums,0);
        return list;
    }public void helper(List<List<Integer>>list,List<Integer>ans,int[]nums,int i){
        if(i==nums.length){
            list.add(new ArrayList<>(ans));
            return ;
        }

        //inc
        ans.add(nums[i]);
        helper(list,ans,nums,i+1);

        ans.remove(ans.size()-1);
        //exc
        helper(list,ans,nums,i+1);
    }

}