class Solution {
    public int minDistance(String w1, String w2) {
        int n=w1.length();
        int m=w2.length();
        Integer[][]dp=new Integer[n+1][m+1];
        return helper(w1,w2,n-1,m-1,dp);
    }
    public static int helper(String w1,String w2,int i,int j,Integer[][]dp){
        if(i<0)return j+1;
        if(j<0)return i+1;
        if(dp[i][j]!=null)return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)){
            return dp[i][j]= helper(w1,w2,i-1,j-1,dp);
        }
        int take=helper(w1,w2,i,j-1,dp);
        int skip=helper(w1,w2,i-1,j,dp);
        int replace=helper(w1,w2,i-1,j-1,dp);
        return dp[i][j]= 1+Math.min(take,Math.min(skip,replace));
    }
}