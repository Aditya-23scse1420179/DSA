class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int rl;
    static int cl;
    class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    boolean[][]visit;
    public int[][] updateMatrix(int[][] mat) {
        rl=mat.length;
        cl=mat[0].length;
        Queue<pair>q=new LinkedList<>();
        visit=new boolean[rl][cl];
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(mat[i][j]==0&&!visit[i][j]){
                    q.offer(new pair(i,j));
                    visit[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];
                if(nrow>=0&&ncol>=0&&nrow<rl&&ncol<cl&&mat[nrow][ncol]==1&&!visit[nrow][ncol]){
                    mat[nrow][ncol]=mat[r][c]+1;
                    visit[nrow][ncol]=true;
                    q.offer(new pair(nrow,ncol));
                }
            }
        }
        return mat;
    }
}