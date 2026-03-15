class Solution {
    public int minSideJumps(int[] obs) {
        int n=obs.length+1;
        Integer[][]dp=new Integer[4][n+1];
        return helper(obs,2,0,dp);
    }public int helper(int[]obs,int curr,int pos,Integer[][]dp){
        int n=obs.length;
        if(pos==n-1)return 0;
        if(dp[curr][pos]!=null)return dp[curr][pos];
        if(obs[pos+1]!=curr){
            return dp[curr][pos]=helper(obs,curr,pos+1,dp);
        }else{
            int ans=(int)1e9;
            for(int i=1;i<=3;i++){
                if(curr!=i&&obs[pos]!=i){
                    ans=Math.min(ans,1+helper(obs,i,pos,dp));
                }
            }
            return dp[curr][pos]= ans;
        }
    }
}