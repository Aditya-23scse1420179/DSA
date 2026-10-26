class Solution {
    // int sum=0;
    int n,m;
    int[]dr={0,0,-1,1};
    int[]dc={-1,1,0,0};
    int[][]g;
    boolean[][]visit;
    public int countIslands(int[][] grid, int k) {
        n=grid.length;
        m=grid[0].length;
        this.g=grid;
        visit=new boolean[n][m];
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0&&!visit[i][j]){
                    if(dfs(i,j)%k==0)count++;
                }
            }
        }
        return count;

    }public long dfs(int r,int c){
        if(r<0||r>=n||c<0||c>=m||visit[r][c]||g[r][c]==0)return 0;
        visit[r][c]=true;
        long sum=g[r][c];
        for(int i=0;i<4;i++){
            sum+=dfs(r+dr[i],c+dc[i]);
        }
        return sum;
    }
}