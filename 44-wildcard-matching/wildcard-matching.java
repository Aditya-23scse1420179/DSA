class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][]dp= new Boolean[s.length()+1][p.length()+1];
        return helper(s,p,s.length(),p.length(),dp);
    }
    public boolean helper(String s,String p,int i,int j,Boolean[][]dp){
        if(dp[i][j]!=null)return dp[i][j];
        if(j==0)return dp[i][j]= (i==0);
        if(i==0){
            for(int k=0;k<j;k++){
                if(p.charAt(k)!='*')return dp[i][j]=false;
            }return dp[i][j]=true;
        }
        char ch =p.charAt(j-1);
        if(s.charAt(i-1)==ch||ch=='?')return dp[i][j]= helper(s,p,i-1,j-1,dp);
        else if (ch=='*'){
            return dp[i][j]=helper(s,p,i-1,j,dp)||helper(s,p,i,j-1,dp);
        }else{
            return dp[i][j]=false;
        }
    }
}