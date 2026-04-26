class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    int n;
    int m;
    boolean [][]visit;
    public boolean containsCycle(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        visit=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j]){
                    if(dfs(i,j,-1,-1,grid))return true;
                }
            }
        }
        return false;
    }public boolean dfs(int r,int c,int pr,int pc,char[][]grid){
        visit[r][c]=true;
        char ch=grid[r][c];
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==ch){
                if(!visit[nr][nc]){
                    if(dfs(nr,nc,r,c,grid))return true;
                }else if(nr!=pr||nc!=pc)return true;
            }
        }
        return false;
    }
}