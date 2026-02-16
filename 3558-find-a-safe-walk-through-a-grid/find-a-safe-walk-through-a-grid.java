class Solution {
    static int []dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static class pair {
        int row;
        int col;
        int dist;
        public pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();//arraylist me aise hi lete hain 
        int [][]dist=new int[n][m];
        for(int[]a:dist){
            Arrays.fill(a,-(int)1e9);
        }
        int sh=health-grid.get(0).get(0);
        dist[0][0]=sh;
        Queue<pair>q=new LinkedList<>();
        q.offer(new pair(0,0,sh));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            int w=curr.dist;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr<0||nr>=n||nc<0||nc>=m)continue;
                    if(w-grid.get(nr).get(nc)>=0&&dist[nr][nc]<w-grid.get(nr).get(nc)){
                        dist[nr][nc]=w-grid.get(nr).get(nc);
                        q.offer(new pair(nr,nc,dist[nr][nc]));
                    }
                
            }
        }
        return dist[n-1][m-1]>=1?true:false;
    }
}