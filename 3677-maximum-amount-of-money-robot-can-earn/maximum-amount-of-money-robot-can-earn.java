class Solution {
    int n,m;
    Integer[][][]dp;
    public int maximumAmount(int[][] coins) {
        n=coins.length;
        m=coins[0].length;
        dp=new Integer[n][m][3];
        return helper(n-1,m-1,coins,2);
    }public int helper(int i,int j,int[][]coins,int k){
        if(i<0||j<0)return -(int)1e9;
        if(i==0&&j==0){
            if(coins[i][j]<0&&k>0)return 0;
            return coins[i][j];
        }
        if(dp[i][j][k]!=null)return dp[i][j][k];
        int ntake=coins[i][j]+Math.max(helper(i,j-1,coins,k),helper(i-1,j,coins,k));
        int take=-(int)1e9;
        if(coins[i][j]<0&&k>0){
            take=Math.max(helper(i,j-1,coins,k-1),helper(i-1,j,coins,k-1));
        }
        return dp[i][j][k]= Math.max(ntake,take);
    }
}