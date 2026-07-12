class Solution {
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    class pair{
        int row,col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    int rl,cl;
    boolean[][]visit;
    
    public int countBattleships(char[][] board) {
        rl=board.length;
        cl=board[0].length;
        visit=new boolean[rl][cl];
        int comp=0;
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(board[i][j]=='X'&&!visit[i][j]){
                    bfs(i,j,board);
                    comp++;
                }
            }
        }
        return comp; 

    }
    public void bfs(int r,int c,char[][]grid){
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
                if(nrow>=0&&ncol>=0&&nrow<rl&&ncol<cl&&!visit[nrow][ncol]&&grid[nrow][ncol]=='X'){
                    visit[nrow][ncol]=true;
                    q.offer(new pair(nrow,ncol));
                }
            }
        }
    }
} 