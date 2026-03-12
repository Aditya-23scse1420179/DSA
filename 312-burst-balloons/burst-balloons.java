class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[]nn=new int[n+2];
        nn[0]=1;
        nn[nn.length-1]=1;
        for(int i=1;i<=n;i++){
            nn[i]=nums[i-1];
        }
        Integer[][]dp=new Integer[n+2][n+2];
        return helper(1,n,nn,dp);
    }public int helper(int i,int j,int[]nn,Integer[][]dp){
        if(i>j)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        int max=-(int)1e9;
        for(int idx=i;idx<=j;idx++){
            int coin=nn[i-1]*nn[idx]*nn[j+1]+helper(i,idx-1,nn,dp)+helper(idx+1,j,nn,dp);
            max=Math.max(max,coin);
        }
        return dp[i][j]=max;
    }
}