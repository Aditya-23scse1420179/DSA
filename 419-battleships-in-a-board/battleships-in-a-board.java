class Solution {
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    // class pair{
    //     int row,int col;
    //     public pair(int row,int col){
    //         this.row=row;
    //         this.col=col;
    //     }
    // }
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
                    dfs(i,j,board);
                    comp++;
                }
            }
        }
        return comp; 

    }public void dfs(int r,int c,char[][]board){
        if(r<0||r>=rl||c<0||c>=cl||visit[r][c]||board[r][c]=='.')return ;
        visit[r][c]=true;
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],board);
        }
    }
} 