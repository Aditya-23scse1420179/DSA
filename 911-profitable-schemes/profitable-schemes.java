class Solution {
    int n;
    Integer[][][]dp;
    public int profitableSchemes(int n, int mp, int[] g, int[] p) {
        this.n=n;
        dp=new Integer[g.length][n+1][mp+1];
        return helper(mp,g,p,0,0,0);
    }public int helper(int mp,int []g,int []p,int idx,int gsize,int currs){
        if(idx>=g.length){
            return currs==mp?1:0;
        }
        if(dp[idx][gsize][currs]!=null)return dp[idx][gsize][currs];
        int ntake=helper(mp,g,p,idx+1,gsize,currs);
        int take=0;
        if(gsize+g[idx]<=n){
            int pro=Math.min(mp,currs+p[idx]);
            take=helper(mp,g,p,idx+1,gsize+g[idx],pro);
        }
        return dp[idx][gsize][currs]= (take+ntake)%1000000007;
    }
}