class Solution {
    Integer[][]dp;
    public int numberOfSets(int n, int k) {
        dp=new Integer[n+1][k+1];
        return helper(0,k,n); 
    }public int helper(int i,int k,int n){
        if(k==0)return 1;
        if(i>=n)return 0;
        if(dp[i][k]!=null)return dp[i][k];
        long skip=helper(i+1,k,n);
        long take=0L;
        for(int j=i+1;j<=n-1;j++){//end points 
            take+=helper(j,k-1,n);
        }
        return dp[i][k]=(int)((skip+take)%1000000007);
    }
}