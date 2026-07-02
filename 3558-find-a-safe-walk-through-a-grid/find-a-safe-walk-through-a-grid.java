class Solution {
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    class pair{
        int row,col,d;
        public pair(int row,int col,int d){
            this.row=row;
            this.col=col;
            this.d=d;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();
        int[][]dist=new int[n][m];
        for(int[]a:dist){
            Arrays.fill(a,-1);
        }
        Queue<pair>q=new LinkedList<>();
        dist[0][0]=health-grid.get(0).get(0);
        q.offer(new pair(0,0,health-grid.get(0).get(0)));
        while(!q.isEmpty()){
            pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int h=curr.d;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m){
                    int nhealth=h-grid.get(nr).get(nc);
                    if(nhealth>=1&&dist[nr][nc]<nhealth){
                        dist[nr][nc]=nhealth;
                        q.offer(new pair(nr,nc,nhealth));
                    }
                }
            }
        }
        return dist[n-1][m-1]>=1;
    }
}