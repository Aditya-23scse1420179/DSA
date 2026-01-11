class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int idx=lb(ans,nums[i]);
            if(idx==ans.size()){
                ans.add(nums[i]);
            }else{
                ans.set(idx,nums[i]);
            }
        }
        return ans.size();
    }public int lb(List<Integer>ans,int target){
        int low=0;
        int high=ans.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(ans.get(mid)>=target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}