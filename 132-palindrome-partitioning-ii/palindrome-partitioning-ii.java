class Solution {
    public int minCut(String s) {
        Integer[]dp=new Integer[s.length()+1];
        return helper(0,s,dp)-1;
    }
    public int helper(int j,String s,Integer[]dp){
        if(j==s.length())return 0;
        if(dp[j]!=null)return dp[j];
        int min=(int)1e9;
        for(int idx=j;idx<s.length();idx++){
            if(ispal(s,j,idx)){
                int cost=1+helper(idx+1,s,dp);
                min=Math.min(min,cost);
            }
        }
        return dp[j]=min;
    }
    public boolean ispal(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}