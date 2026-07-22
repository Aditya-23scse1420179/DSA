class Solution {
    Long[]dp;
    public long mostPoints(int[][] questions) {
        dp=new Long[questions.length+1];
        return helper(questions,0);
    }public long helper(int[][]question,int idx){
        if(idx>=question.length)return 0;
        if(dp[idx]!=null)return dp[idx];
        long take=helper(question,idx+question[idx][1]+1)+question[idx][0];
        long skip=helper(question,idx+1);
        return dp[idx]=Math.max(take,skip);
    }
}