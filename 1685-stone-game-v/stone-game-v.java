class Solution {
    int n;
    int[]pre;
    Integer[][]dp;
    public int stoneGameV(int[] stone) {
        n=stone.length;
        dp=new Integer[n][n];
        pre=new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+stone[i];
        }
        return helper(0,n-1,pre);
    }public int helper(int l,int r,int[]pre){
        if(l==r)return 0;
        if(dp[l][r]!=null)return dp[l][r];
        int best=0;
        for(int i=l;i<r;i++){
            int ls=pre[i+1]-pre[l];
            int rs=pre[r+1]-pre[i+1];
            if(ls<rs){
                best=Math.max(best,ls+helper(l,i,pre));
            }
            else if(rs<ls){
                best=Math.max(best,rs+helper(i+1,r,pre));
            }else{
                best=Math.max(best,ls+helper(l,i,pre));
                best=Math.max(best,rs+helper(i+1,r,pre));
            }
        }
        return dp[l][r]=best;
    }
}