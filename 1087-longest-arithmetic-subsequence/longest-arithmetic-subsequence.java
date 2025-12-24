class Solution {
    public int longestArithSeqLength(int[] nums) {
        int dp[][]= new int [nums.length][1001];
        int max=0;
        for(int x[]:dp){
            Arrays.fill(x,1);
        }
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                int diff=nums[i]-nums[j];
                if(dp[j][diff+500]+1>dp[i][diff+500]){
                    dp[i][diff+500]=dp[j][diff+500]+1;
                    max=Math.max(dp[i][diff+500],max);
                }
            }
        }
        return max;
    }
}