class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,1,-1};
    static int rl;
    static int cl;
    public void solve(char[][] board) {
        rl=board.length;
        cl=board[0].length;
        boolean[][]visit=new boolean[rl][cl];
        for(int i=0;i<rl;i++){
            if(board[i][0]=='O') dfs(i,0,board,visit);
            if(board[i][cl-1]=='O') dfs(i,cl-1,board,visit);
        }
        for(int j=0;j<cl;j++){
            if(board[0][j]=='O')dfs(0,j,board,visit);
            if(board[rl-1][j]=='O')dfs(rl-1,j,board,visit);
        }
        for (int i=0;i<rl;i++){
            for (int j=0; j< cl; j++){
                if(board[i][j]=='O'&&!visit[i][j]) {
                    board[i][j]='X'; 
                }
            }
        }
        
    }
    public void dfs(int r,int c,char[][]board,boolean[][]visit){
        if(r<0||c<0||r>=rl||c>=cl||board[r][c]=='X')return;
        if(visit[r][c]==true)return;
        visit[r][c]=true;
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],board,visit);
        }
    }
}
