class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair>q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new pair(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }int level=0;
        while(!q.isEmpty()){
            boolean rotten=false;
            int size=q.size();
            while(size-->0){
                pair curr=q.remove();
                int r=curr.row;
                int c=curr.col;
                for(int i=0;i<4;i++){
                    int nr=r+dr[i];
                    int nc=c+dc[i];
                    if(nr<0||nr>=n||nc<0||nc>=m)continue;
                    if(grid[nr][nc]==1){
                        fresh--;
                        grid[nr][nc]=2;
                        rotten=true;
                        q.offer(new pair(nr,nc));
                    }
                }
            }
            if(rotten)level++;
        }
        return fresh==0?level:-1;
    }
}