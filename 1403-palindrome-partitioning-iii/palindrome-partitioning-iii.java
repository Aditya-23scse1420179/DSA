class Solution {
    public int palindromePartition(String s, int k) {
        Integer[][]dp=new Integer[s.length()][k+1];
        return helper(s,0,k,dp);
    }public int helper(String s,int idx,int k,Integer[][]dp){
        if(idx==s.length()&&k==0)return 0;
        if(idx==s.length()||k==0)return (int)1e9;
        if(dp[idx][k]!=null)return dp[idx][k];
        int min=(int)1e9;
        for(int i=idx;i<s.length();i++){
            int a=ispal(idx,i,s)+helper(s,i+1,k-1,dp);
            min=Math.min(min,a);
        }
        return dp[idx][k]=min;

    }public int ispal(int i,int j,String s){
        int count=0;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                count++;
            }
            i++;j--;
        }    
        return count;
    }
}