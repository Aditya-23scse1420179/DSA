class Solution {
    long[]dp;
    public long mostPoints(int[][] questions) {
        dp=new long[questions.length+1];
        for(int i=questions.length-1;i>=0;i--){
            long take=questions[i][0]+((i+questions[i][1]+1)<questions.length?dp[i+questions[i][1]+1]:0);
            long skip=dp[i+1];
            dp[i]=Math.max(take,skip);
        }
        return dp[0];
    }
}