class Solution {
    Integer[][][]dp;
    int MOD=1000000007;
    public int numOfArrays(int n, int m, int k) {
        dp=new Integer[n+1][m+1][k+1];
        return helper(0,0,0,n,m,k);
    }public int helper(int idx,int cmax,int val,int n,int m,int k){
        if(val>k)return 0;
        if(idx==n){
            if(val==k)return 1;
            return 0;
        }
        if(dp[idx][cmax][val]!=null)return dp[idx][cmax][val];
        long ans=0;
        for(int i=1;i<=m;i++){
            if(i>cmax){
                ans+=helper(idx+1,i,val+1,n,m,k);
            }else{
                ans+=helper(idx+1,cmax,val,n,m,k);
            }
        }
        return dp[idx][cmax][val]= (int)(ans%MOD);
    }
}