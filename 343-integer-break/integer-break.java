class Solution {
    Integer[]dp;
    public int integerBreak(int n) {
        dp=new Integer[n+1];
        return helper(n);
        
    }public int helper(int n){
        if(n==1)return 1;
        if(dp[n]!=null)return dp[n];
        int result=1*(n-1);
        for(int i=1;i<=n-1;i++){
            int s1=i*(n-i);
            int s2=i*helper(n-i);
            result=Math.max(result,Math.max(s1,s2));
        }
        return dp[n]=result;
    }
}