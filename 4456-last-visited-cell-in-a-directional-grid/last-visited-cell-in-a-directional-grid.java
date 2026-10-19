class Solution {
    char[][]g;
    int n,m;
    boolean[][]visit;
    public int[] lastVisitedCell(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        this.g=grid;
        visit=new boolean[n][m];
        return helper(0,0);
    }public int[]helper(int r,int c){
        visit[r][c]=true;
        int nr=r;
        int nc=c;
        if(g[r][c]=='R')nc++;
        else if(g[r][c]=='L')nc--;
        else if(g[r][c]=='U')nr--;
        else if(g[r][c]=='D')nr++;
        if(nr>=0&&nr<n&&nc>=0&&nc<m&&!visit[nr][nc]){
            return helper(nr,nc);
        }
        return new int[]{r,c};
    }
}