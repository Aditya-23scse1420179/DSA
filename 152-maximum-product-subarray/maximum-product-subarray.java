class Solution {
    public int maxProduct(int[] nums) {
        int min=1;
        int max=1;
        int ans=-(int)1e9;
        for(int i=0;i<nums.length;i++){
            if(min==0)min=1;
            if(max==0)max=1;
            min*=nums[i];
            max*=nums[nums.length-i-1];
            ans=Math.max(ans,Math.max(min,max));
        }
        return ans;
    }
}