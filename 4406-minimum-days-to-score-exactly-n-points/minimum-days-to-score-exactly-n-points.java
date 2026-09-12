class Solution {
    Integer[]dp;
    public int minDays(int n) {
        dp=new Integer[n+1];
        return helper(n);
    }public int helper(int rem){
        if(rem==0)return 0;
        if(rem<0)return (int)1e9;
        if(dp[rem]!=null)return dp[rem];
        int minday=(int)1e9;
        for(int k=1;;k++){
            int p=(k*(k+1))/2;
            if(p>rem)break;
            int remm=rem-p;
            int take=k;
            if(remm>0){
                take++;
            }
            take+=helper(remm);
            minday=Math.min(minday,take);
        }
        return dp[rem]= minday;
    }
}