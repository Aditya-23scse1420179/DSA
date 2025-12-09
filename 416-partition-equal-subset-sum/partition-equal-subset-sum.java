class Solution{
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum =0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%2!=0)return false;
        int target = sum/2;
        boolean [][]dp= new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            int curr=nums[i-1];
            for(int s=1;s<=target;s++){
                dp[i][s]=dp[i-1][s];
                if(s>=curr){
                    dp[i][s]=dp[i][s]||dp[i-1][s-curr];
                }
            }
        }
        return dp[n][target];
    }
}
