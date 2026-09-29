class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int l=0,ans=0;
        for(int r=1;r<nums.length;r++){
            while(nums[r]-nums[l]>1)l++;
            if(nums[r]-nums[l]==1){
                ans=Math.max(ans,r-l+1);
            }
            
        }
        return ans;
    }
}