class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        Integer[][]dp=new Integer[n+1][m+1];
        return helper(s,t,0,0,dp);
    }
    public static int helper(String s,String t,int i,int j,Integer[][]dp){
        int n=s.length();
        int m=t.length();
        if(j==m)return 1;
        if(i==n)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]= helper(s,t,i+1,j+1,dp)+helper(s,t,i+1,j,dp);
        }
        return dp[i][j]=helper(s,t,i+1,j,dp);
    }
}