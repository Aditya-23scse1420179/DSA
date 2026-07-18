class Solution {
    Boolean[][]dp;
    public boolean isMatch(String s, String p) {
        dp=new Boolean[s.length()+1][p.length()+1];
        return helper(s,p,s.length(),p.length());
    }
    public boolean helper(String s,String p,int i,int j){
        if(j==0)return (i==0);
        if(dp[i][j]!=null)return dp[i][j];
        boolean ans;
        char pc = p.charAt(j-1);
        if (pc == '*') {
            ans = helper(s,p,i,j-2)||(i>0&&(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.')&& helper(s, p, i-1, j));
        } else {
            ans = (i>0&&(s.charAt(i-1)==pc||pc=='.'))&& helper(s, p, i-1, j-1);
        }
        return dp[i][j]=ans;
    }
}