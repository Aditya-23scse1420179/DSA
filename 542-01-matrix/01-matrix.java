class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    class pair{
        int row,col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        boolean[][]visit=new boolean[n][m];
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
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
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&!visit[nr][nc]&&mat[nr][nc]==1){
                    mat[nr][nc]=mat[r][c]+1;
                    visit[nr][nc]=true;
                    q.offer(new pair(nr,nc));
                }
            }
        }
        return mat;
    }
}