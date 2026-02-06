class Solution {
    static int dr [] = {-1 , 1 , 0 ,0};
    static int dc [] = {0 , 0 , -1 , 1}; 
    static int rowL;
    static int colL;
    static char[]dir={'U','D','R','L'};
    static class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int closedIsland(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;
        boolean [][] visited = new boolean [rowL][colL];
        for(int i = 0 ; i < rowL ; i++){
            if(grid[i][0]==0)bfs(i,0,visited,grid);
            if(grid[i][colL-1] == 0) bfs(i , colL-1 , visited , grid);
            
        }for(int j=0;j<colL;j++){
            if(grid[0][j]==0)bfs(0,j,visited,grid);
            if(grid[rowL-1][j]==0)bfs(rowL-1,j,visited,grid);
        }int count=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]==0&&!visited[i][j]){
                    bfs(i,j,visited,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int r , int c , boolean[][] visited ,int [][] grid ){
        Queue<pair>q=new LinkedList<>();
        visited[r][c]=true;
        q.offer(new pair(r,c));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r1=curr.row;
            int c1=curr.col;
            for(int i=0;i<4;i++){
                int nrow=r1+dr[i];
                int ncol=c1+dc[i];
                if(nrow>=0&&ncol>=0&&nrow<rowL&&ncol<colL&&!visited[nrow][ncol]&&grid[nrow][ncol]==0){
                    visited[nrow][ncol]=true;
                    q.offer(new pair(nrow,ncol));
                }
            }
        }
        
    }
}