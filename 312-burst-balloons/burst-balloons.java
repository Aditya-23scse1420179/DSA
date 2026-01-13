class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int []arr=new int [n+2];
        arr[0]=1;
        arr[arr.length-1]=1;
        Integer[][]dp=new Integer[arr.length][arr.length];
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
        return helper(arr,1,arr.length-2,dp);
    }public static int helper(int[]arr,int i,int j,Integer[][]dp){
        if(i>j)return 0;
        int max=-(int)1e9;
        if(dp[i][j]!=null)return dp[i][j];
        for(int idx=i;idx<=j;idx++){
            int cost=arr[i-1]*arr[idx]*arr[j+1]+helper(arr,i,idx-1,dp)+helper(arr,idx+1,j,dp);
            max=Math.max(max,cost);
        }
        return dp[i][j]=max;
    }
}