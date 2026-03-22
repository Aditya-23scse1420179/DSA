class Solution {
    Integer[][][]dp=new Integer[50][50][50];
    int[][]grid;
    int n;
    public int cherryPickup(int[][] g) {
        grid=g;
        n=grid.length;
        return Math.max(0,helper(0,0,0));

    }public int helper(int r1,int c1,int c2){
        int r2=r1+c1-c2;
        if(r1>=n||c1>=n||r2>=n||c2>=n||grid[r1][c1]==-1||grid[r2][c2]==-1)return Integer.MIN_VALUE;
        if(r1==n-1&&c1==n-1)return grid[r1][c1];
        if(dp[r1][c1][c2]!=null)return dp[r1][c1][c2];
        int ans=grid[r1][c1];
        if(c1!=c2)ans+=grid[r2][c2];
        int temp=Math.max(helper(r1,c1+1,c2+1),helper(r1+1,c1,c2));//right right 
        temp=Math.max(temp,helper(r1+1,c1,c2+1));//temp aur down right ka max
        temp=Math.max(temp,helper(r1,c1+1,c2));//temp aur right down ka max
        ans+=temp;// fir temp me add kar do 
        return dp[r1][c1][c2]=ans;
    }
}