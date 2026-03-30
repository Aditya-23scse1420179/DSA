class Solution {
    int n;
    int m;
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    boolean[][]visit;
    public boolean containsCycle(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        visit=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j]){
                    if(dfs(i,j,-1,-1,grid[i][j],grid))return true;
                }
            }
        }
        return false;
    }public boolean dfs(int i,int j,int pr,int pc,char ch,char[][] grid){
        if(visit[i][j])return true;
        visit[i][j]=true;
        for(int k=0;k<4;k++){
            int nr=i+dr[k];
            int nc=j+dc[k];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==ch){
                if(!(nr==pr&&nc==pc)){
                    if(dfs(nr,nc,i,j,grid[nr][nc],grid))return true;
                }
            }

        }
        return false;
    }
}