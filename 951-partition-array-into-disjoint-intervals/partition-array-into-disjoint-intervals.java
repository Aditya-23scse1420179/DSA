class Solution {
    public int partitionDisjoint(int[] nums) {
        int ans=1,lmax=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<lmax){
                ans=i+1;
                lmax=max;
            }else{
                max=Math.max(max,nums[i]);
            }
        }
        return ans;
    }
}