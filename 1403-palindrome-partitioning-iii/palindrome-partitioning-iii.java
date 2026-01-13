class Solution {
    public int palindromePartition(String s, int k) {
        Integer[][]dp=new Integer[s.length()+1][s.length()+1
        ];
        return helper(0,s,k,dp);
    }public static int helper(int idx,String s,int k,Integer[][]dp){
        if(idx==s.length()&&k==0)return 0;
        if(idx==s.length()||k==0)return (int)1e9;
        if(dp[idx][k]!=null)return dp[idx][k];
        int min=(int)1e9;
        for(int i=idx;i<s.length();i++){
            int cost=ispal(idx,i,s)+helper(i+1,s,k-1,dp);
            min=Math.min(min,cost);
        }
        return dp[idx][k]=min;
    }public static int ispal(int i,int j,String s){
        int changes=0;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                changes++;
            }
            i++;
            j--;
        }
        return changes;
    }
}    