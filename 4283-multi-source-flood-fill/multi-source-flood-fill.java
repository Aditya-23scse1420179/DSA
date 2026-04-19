class Solution {
    static int []dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    class pair{
        int row,col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][]grid=new int[n][m];
        Queue<pair>q=new LinkedList<>();
        Arrays.sort(sources,(a,b)->b[2]-a[2]);
        for(int[]a:sources){
            int r=a[0],c=a[1],col=a[2];
            q.offer(new pair(r,c));
            grid[r][c]=col;
        }
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            // int col=curr.color;
            int color=grid[r][c];
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==0){
                    // if(sources[nr][nc]<col){
                        grid[nr][nc]=color;
                        q.offer(new pair(nr,nc));
                    //}
                }
            }
        }
        return grid;
    }
}