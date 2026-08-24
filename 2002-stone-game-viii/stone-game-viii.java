class Solution {
    int[]pre;
    int[]arr;
    Integer[]dp;
    public int stoneGameVIII(int[] stones) {
        dp=new Integer[stones.length];
        this.arr=stones;
        pre=new int[stones.length];
        pre[0]=stones[0];
        for(int i=1;i<stones.length;i++){
            pre[i]=pre[i-1]+stones[i];
        }
        return helper(1);
    }public int helper(int i){
        if(i==arr.length-1)return pre[i];
        if(dp[i]!=null)return dp[i];
        int ntake=helper(i+1);
        int take=pre[i]-helper(i+1);
        return dp[i]=Math.max(ntake,take);
    }
}