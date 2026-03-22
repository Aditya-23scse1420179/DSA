class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        Arrays.sort(nums);
        helper(ans,list,nums,0);
        return ans;
    }public void helper(List<List<Integer>>ans,List<Integer>list,int[]nums,int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        helper(ans,list,nums,i+1);
        list.remove(list.size()-1);
        //exc jabtak same tabtak skipp
        int idx=i+1;
        while(idx<nums.length&&nums[idx]==nums[idx-1])idx++;
        helper(ans,list,nums,idx);
    }
}