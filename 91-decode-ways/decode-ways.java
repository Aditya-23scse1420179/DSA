class Solution {
    public int numDecodings(String s) {
        Integer[]dp=new Integer[s.length()];
        return helper(s,0,dp);
    }
    public static int helper(String s,int i,Integer[]dp){
        if(i==s.length())return 1;
        if(s.charAt(i)=='0')return 0;
        if(dp[i]!=null)return dp[i];
        int count = helper(s, i + 1,dp);
        int take =helper(s,i+1,dp);
        if(i+1<s.length()){
            int num =Integer.parseInt(s.substring(i,i +2));
            if (num>= 10&&num <=26){
                count +=helper(s,i +2,dp);
            }
        }
        return dp[i]=count ;
    }
}