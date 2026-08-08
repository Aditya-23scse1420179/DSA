class Solution {
    public int maximumAmount(int[][] coins) {
        int n=coins.length,m=coins[0].length;
        int[][][]dp=new int[n][m][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-(int)1e9;
                }
            }
        }
        for(int k=0;k<3;k++){
            if(coins[0][0]<0&&k>0)dp[0][0][k]=0;
            else dp[0][0][k]=coins[0][0];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j==0)continue;
                for(int k=0;k<3;k++){
                    
                    int ntake=-(int)1e9;
                    int val=coins[i][j];
                    if(i>0)ntake=Math.max(ntake,dp[i-1][j][k]);
                    if(j>0)ntake=Math.max(ntake,dp[i][j-1][k]);
                    if(ntake>-(int)1e9){
                        dp[i][j][k]=Math.max(dp[i][j][k],val+ntake);
                    }
                    if(val<0&&k>0){
                        int take=-(int)1e9;
                        if(i>0)take=Math.max(take,dp[i-1][j][k-1]);
                        if(j>0)take=Math.max(take,dp[i][j-1][k-1]);
                        if(take>-(int)1e9){
                            dp[i][j][k]=Math.max(dp[i][j][k],take);
                        }
                    }
                }
            }
        }
        int ans=-(int)1e9;
        for(int i=0;i<3;i++){
            ans=Math.max(ans,dp[n-1][m-1][i]);
        }
        return ans;
    }
}