class Solution {
    public static int helper(int[]nums,int s,int l){
        int prev2=nums[s];
        int prev1=Math.max(nums[s],nums[s+1]);
        for(int i=s+2;i<l;i++){
            int curr=Math.max(prev1,nums[i]+prev2);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        int ans1 = helper(nums,1,nums.length);
        int ans2=helper(nums,0,nums.length-1);
        return Math.max(ans1,ans2);
    }
}
