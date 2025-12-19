class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        Integer[][]dp=new Integer[n+1][m+1];
        return helper(s,t,s.length()-1,t.length()-1,dp);
    }
    public static int helper(String s,String t,int i,int j,Integer[][]dp){
        if(j<0)return 1;
        if(i<0)return 0;
        if(i<j)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]= helper(s,t,i-1,j-1,dp)+helper(s,t,i-1,j,dp);
        }
        return dp[i][j]=helper(s,t,i-1,j,dp);
    }
}