class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[]ncut=new int[m+2];
        ncut[0]=0;
        ncut[ncut.length-1]=n;
        Arrays.sort(cuts);
        for(int i=1;i<=cuts.length;i++){
            ncut[i]=cuts[i-1];
        }
        Integer[][]dp= new Integer[m+1][m+1];
        return helper(1,cuts.length,ncut,dp);
    }public static int helper(int i,int j,int[]ncut,Integer[][]dp){
        if(i>j)return 0;
        int min=(int)1e9;
        if(dp[i][j]!=null)return dp[i][j];
        for(int idx=i;idx<=j;idx++){
            int cost=ncut[j+1]-ncut[i-1]+helper(i,idx-1,ncut,dp)+helper(idx+1,j,ncut,dp);
            min=Math.min(min,cost);
        }
        return dp[i][j]=min;
    }
}