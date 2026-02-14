class Solution {
    Double[][]dp;
    public double champagneTower(int poured, int query_row, int query_glass) {
        dp=new Double[query_row+1][query_glass+1];
        return Math.min(1.0,helper(query_row,query_glass,poured));
    }public double helper(int i,int j,int k){
        if(i<0||j<0||j>i)return 0;
        if(i==0&&j==0)return k;
        if(dp[i][j]!=null)return dp[i][j];
        double left=Math.max(0,helper(i-1,j-1,k)-1)/2;
        double right=Math.max(0,helper(i-1,j,k)-1)/2;
        return dp[i][j]=left+right;
    }
}