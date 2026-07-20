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
            int num=i*Math.max(n-i,helper(n-i));
            result=Math.max(result,num);
        }
        return dp[n]=result;
    }
}