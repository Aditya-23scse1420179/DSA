class Solution {static int[]dr={-1,1,0,0};
    static int[]dc={0,0,1,-1};
    static int rowL;
    static int colL;
    public int islandPerimeter(int[][] grid) {rowL=grid.length;
        colL=grid[0].length;
        boolean[][]visit=new boolean[rowL][colL];
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(!visit[i][j]&&grid[i][j]==1){
                    return dfs(i,j,visit,grid);
                }
            }
        }
        return 0;
        
    }public int dfs(int r,int c,boolean[][]visit,int[][]grid){
        if(r<0||c<0||r>=rowL||c>=colL||grid[r][c]==0)return 1;
        if(visit[r][c]==true)return 0;
        visit[r][c]=true;
        int perimeter=0;
        for(int i=0;i<4;i++){
            perimeter+=dfs(r+dr[i],c+dc[i],visit,grid);
        }
        return perimeter;
    }
}