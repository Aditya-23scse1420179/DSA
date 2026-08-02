class Solution {
    Integer[][]dp;
    public int helper(int []piles,int i,int j){
        if(i==j)return piles[i];
        if(dp[i][j]!=null)return dp[i][j];
        int alice=piles[i]-helper(piles,i+1,j);
        int bob = piles[j]-helper(piles,i,j-1);
        return dp[i][j]= Math.max(alice,bob);
    }
    public boolean stoneGame(int[] piles) {
        dp= new Integer[piles.length][piles.length];
        return helper(piles,0,piles.length-1)>=0;
    }
}