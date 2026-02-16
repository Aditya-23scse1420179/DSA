class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static class pair{
        int row;
        int col;
        int obs;
        public pair(int row,int col,int obs){
            this.row=row;
            this.col=col;
            this.obs=obs;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][][]visit=new boolean[n][m][k+1];
        Queue<pair>q=new LinkedList<>();
        q.offer(new pair(0,0,k));
        visit[0][0][k]=true;
        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                pair curr=q.remove();
                int r=curr.row;
                int c=curr.col;
                int w=curr.obs;
                if(r==n-1&&c==m-1)return step;
                for(int i=0;i<4;i++){
                    int nr=r+dr[i];
                    int nc=c+dc[i];
                    if(nr<0||nr>=n||nc<0||nc>=m)continue;
                    if(grid[nr][nc]==0&&!visit[nr][nc][w]){
                        q.offer(new pair(nr,nc,w));
                        visit[nr][nc][w]=true;
                    }else if(grid[nr][nc]==1&&w>=1&&!visit[nr][nc][w-1]){//-1 lagega kyunki next cell me jayenge ak k kam ho chuka hoga 1 ki vagah se
                        q.offer(new pair(nr,nc,w-1));
                        visit[nr][nc][w-1]=true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}