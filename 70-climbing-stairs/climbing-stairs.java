class Solution {
    Integer[]dp;
    public int climbStairs(int n) {
        dp=new Integer[n];
        return helper(n,0);
    }public int helper(int n,int jump){
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2)return 2;
        if(dp[jump]!=null)return dp[jump];
        int jump1=helper(n-1,jump+1);
        int jump2=helper(n-2,jump+2);
        return dp[jump]=jump1+jump2;
    }
}