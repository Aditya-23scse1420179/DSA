class Solution {
    Integer[]dp;
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        dp=new Integer[pairs.length];
        return helper(0,pairs,-(int)1e9);
    }public int helper(int idx,int [][]pairs,int pre){
        if(idx>=pairs.length)return 0;
        if(dp[idx]!=null)return dp[idx];
        int inc=0,skip=0;
        if(pairs[idx][0]>pre){
            inc=1+helper(idx+1,pairs,pairs[idx][1]);
        }
        skip=helper(idx+1,pairs,pre);
        return dp[idx]=Math.max(inc,skip);
    }
}