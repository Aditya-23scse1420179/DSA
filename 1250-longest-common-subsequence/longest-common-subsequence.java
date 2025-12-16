class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m =s2.length();
        Integer[][]dp=new Integer[n+1][m+1];
        return lcs(s1.length(),s2.length(),s1,s2,dp);
    }
    public int lcs(int idx1,int idx2,String s1,String s2,Integer[][]dp){
        if(idx1==0||idx2==0)return 0;
        if(dp[idx1][idx2]!=null)return dp[idx1][idx2];
        if(s1.charAt(idx1-1)==s2.charAt(idx2-1)){
            return dp[idx1][idx2]= 1+lcs(idx1-1,idx2-1,s1,s2,dp);
        }
        else{
            return dp[idx1][idx2]=Math.max(lcs(idx1-1,idx2,s1,s2,dp),lcs(idx1,idx2-1,s1,s2,dp));
        }
    }
    
}