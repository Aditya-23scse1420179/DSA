class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        Integer[][]dp=new Integer[n+1][m+1];
        return helper(s,t,n,m,dp);
    }
    public static int helper(String s,String t,int i,int j,Integer[][]dp){
        if(j==0)return 1;
        if(i==0)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=helper(s,t,i-1,j-1,dp)+helper(s,t,i-1,j,dp);
        }else{
            return dp[i][j]=helper(s,t,i-1,j,dp);
        }
    }
}