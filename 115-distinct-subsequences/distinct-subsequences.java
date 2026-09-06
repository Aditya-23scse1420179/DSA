class Solution {
    Integer[][]dp;
    public int numDistinct(String s, String t) {
        dp=new Integer[s.length()+1][t.length()+1];
        return helper(s,t,s.length(),t.length());
    }public int helper(String s,String t,int i,int j){
        if(j==0)return 1;
        if(i==0)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=helper(s,t,i-1,j-1)+helper(s,t,i-1,j);
        }
        else{
            return dp[i][j]=helper(s,t,i-1,j);
        }

    }
}