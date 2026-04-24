class Solution {
    int[]freq;
    Integer[]dp;
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        freq=new int[100001];
        dp=new Integer[100001];
        int max=0;
        for(int a:nums){
            freq[a]++;
            max=Math.max(max,a);
        }
        return helper(max);
    }public int helper(int x){
        if(x<0)return 0;
        if(dp[x]!=null)return dp[x];
        int take1=helper(x-1);
        int take2=helper(x-2)+freq[x]*x;
        return dp[x]=Math.max(take1,take2);
    }
}