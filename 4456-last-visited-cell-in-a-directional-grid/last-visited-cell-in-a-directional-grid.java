class Solution {
     boolean[][]visit;
     int n,m;
    public int[] lastVisitedCell(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        visit=new boolean[n][m];
        return helper(grid,0,0);
    }public int[]helper(char[][]grid,int r,int c){
        visit[r][c]=true;
        int nr=r;
        int nc=c;
        if(grid[r][c]=='L')nc--;
        else if(grid[r][c]=='R')nc++;
        else if(grid[r][c]=='U')nr--;
        else if(grid[r][c]=='D')nr++;
        if(nr>=0&&nr<n&&nc>=0&&nc<m&&!visit[nr][nc]){
            return helper(grid,nr,nc);
        }
        return new int[]{r,c};

    }
}