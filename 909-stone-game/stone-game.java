class Solution {
    public int helper(int []piles,int i,int j,Integer[][]dp){
        if(i==j)return piles[i];
        if(dp[i][j]!=null)return dp[i][j];
        int alice=piles[i]-helper(piles,i+1,j,dp);
        int bob = piles[j]-helper(piles,i,j-1,dp);
        return dp[i][j]= Math.min(alice,bob);
    }
    public boolean stoneGame(int[] piles) {
        int i=0;
        int j=piles.length-1;
        Integer[][]dp= new Integer[piles.length][piles.length];
        return helper(piles,i,j,dp)<0;
    }
}