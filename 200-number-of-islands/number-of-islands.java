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
    public int numIslands(char[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][]visit=new boolean[rowL][colL];
        int component=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(!visit[i][j]&&grid[i][j]=='1'){//take 1 in ' 'because array is of char type
                    bfs(i,j,visit,grid);
                    component++;
                }
            }
        }
        return component;
    }public void bfs(int r,int c,boolean[][]visit,char[][]grid){
        Queue<pair>q=new LinkedList<>();
        visit[r][c]=true;
        q.offer(new pair(r,c));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r1=curr.row;
            int c1=curr.col;
        
            for(int i=0;i<4;i++){
                int nrow=r1+dr[i];
                int ncol=c1+dc[i];
                if(nrow>=0&&ncol>=0&&nrow<rowL&&ncol<colL&&!visit[nrow][ncol]&&grid[nrow][ncol]=='1'){
                    visit[nrow][ncol]=true;
                    q.offer(new pair(nrow,ncol));
                }
            }
        }
    }
}