class Solution {
    Integer[][]dp;
    public int minimumCoins(int[] prices) {
        dp=new Integer[prices.length][prices.length+2];
        return helper(0,prices,-1);
    }public int helper(int idx,int[]arr,int free){
        if(idx>=arr.length)return 0;
        int f=Math.min(free,arr.length);
        if(dp[idx][f+1]!=null)return dp[idx][f+1];
        int nf=idx+(idx+1);
        int take=arr[idx]+helper(idx+1,arr,nf);
        int ntake=(int)1e9;
        if(idx<=free){
            ntake=helper(idx+1,arr,free);
        }
        return  dp[idx][f+1]= Math.min(take,ntake);
    }
}