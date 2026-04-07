class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    Integer[][][]dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new Integer[51][51][51];
        return helper(m,n,maxMove,startRow,startColumn);
    }public int helper(int m,int n,int maxmoves,int r,int c){
        if(r<0||r>=m||c<0||c>=n)return 1;
        if(maxmoves==0)return 0;
        if(dp[maxmoves][r][c]!=null)return dp[maxmoves][r][c];
        int ans=0;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            ans=(ans+helper(m,n,maxmoves-1,nr,nc))%1000000007;
        }
        return dp[maxmoves][r][c]= ans;

    }
}