class Solution {
    Integer[]dp;
    public int minCut(String s) {
        dp=new Integer[s.length()+1];
        return helper(s,0)-1;
    }public int helper(String s,int idx){
        if(idx==s.length())return 0;
        if(dp[idx]!=null)return dp[idx];
        int min=(int)1e9;
        for(int i=idx;i<s.length();i++){
            
            if(pal(s,idx,i)){
                int cost=1+helper(s,i+1);
                min=Math.min(min,cost);
            }
        }
        return dp[idx]=min;
    }public boolean pal(String s,int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))return false;
        }
        return true;
    }
}