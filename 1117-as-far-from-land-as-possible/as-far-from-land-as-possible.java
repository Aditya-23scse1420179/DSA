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
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)q.offer(new pair(i,j));
            }
        }int res=-1;
        if(q.isEmpty()||q.size()==n*n)return -1;
        while(!q.isEmpty()){
            res++;
            int size=q.size();
            while(size-->0){
                
                pair curr=q.remove();
                int r=curr.row;
                int c=curr.col;
                for(int i=0;i<4;i++){
                    int nr=r+dr[i];
                    int nc=c+dc[i];
                    if(nr>=0&&nr<n&&nc>=0&&nc<n&&grid[nr][nc]==0){
                        grid[nr][nc]=1;
                        q.offer(new pair(nr,nc));
                    }
                }
            }
        }
        return res;
    }
}