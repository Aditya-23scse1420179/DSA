class Solution {
    Integer[]dp;
    public String stoneGameIII(int[] s) {
        dp=new Integer[s.length];
        int ans=helper(0,s);
        if(ans>0)return "Alice";
        else if(ans<0)return "Bob";
        else return "Tie";
    }public int helper(int i,int[]stone){
        if(i>=stone.length)return 0;
        int take=0,best=-(int)1e9;
        if(dp[i]!=null)return dp[i];
        for(int k=0;k<3&&i+k<stone.length;k++){
            take+=stone[i+k];
            best=Math.max(best,take-helper(i+k+1,stone));
        }
        return dp[i]=best;
    }
}