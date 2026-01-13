class Solution {
    int n;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n=arr.length;
        Integer[]dp=new Integer[n+k];
        return helper(arr,0,k,dp);

    }public static int helper(int[]arr,int idx,int k,Integer[]dp){
        if(idx==arr.length)return 0;
        int len=0;
        int max=-(int)1e9;
        int maxA=-(int)1e9;
        if(dp[idx]!=null)return dp[idx];
        for(int i=idx;i<Math.min(arr.length,idx+k);i++){
            len++;
            max=Math.max(arr[i],max);
            int cost=max*len+helper(arr,i+1,k,dp);
            maxA=Math.max(maxA,cost);
        }
        return dp[idx]=maxA;
    }
}