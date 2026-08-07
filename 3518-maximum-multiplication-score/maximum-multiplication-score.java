class Solution {
    Long[][]dp;
    public long maxScore(int[] a, int[] b) {
        dp=new Long[a.length][b.length];
        return helper(0,0,a,b);
    }public long helper(int ai,int bi,int[]a,int[]b){
        if(ai==4)return 0;
        if(bi>=b.length)return Long.MIN_VALUE/2;
        if(dp[ai][bi]!=null)return dp[ai][bi];
        long ntake=helper(ai,bi+1,a,b);
        long take=(long)a[ai]*b[bi]+helper(ai+1,bi+1,a,b);
        return dp[ai][bi]=Math.max(ntake,take);
    }
}