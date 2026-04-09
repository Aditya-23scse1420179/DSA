class Solution {
    int n;
    public int maxSizeSlices(int[] slices) {
        n=slices.length;
        int take=n/3;
        Integer[][]dp1=new Integer[n][take+1];
        Integer[][]dp2=new Integer[n][take+1];
        
        return Math.max(helper(slices,0,n-1,take,dp1),helper(slices,1,n,take,dp2));
    }public int helper(int[]slices,int s,int l,int k,Integer[][]dp){
        if(k==0)return 0;
        if(s>=l)return -(int)1e9;
        if(dp[s][k]!=null)return dp[s][k];
        int pick=helper(slices,s+2,l,k-1,dp)+slices[s];
        int npick=helper(slices,s+1,l,k,dp);
        return dp[s][k]=Math.max(pick,npick);
    }
}