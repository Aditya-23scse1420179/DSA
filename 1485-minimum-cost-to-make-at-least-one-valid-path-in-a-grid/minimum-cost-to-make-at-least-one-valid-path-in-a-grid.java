class Solution {
    class pair{
        int r,c,w;
        public pair(int r,int c,int w){
            this.r=r;
            this.c=c;
            this.w=w;
        }
    }
    int[]dr={0,0,1,-1};
    int[]dc={1,-1,0,0};
    public int minCost(int[][] grid) {
        int rl=grid.length;
        int cl=grid[0].length;
        int[][]dist=new int[rl][cl];
        for(int[]a:dist){
            Arrays.fill(a,(int)1e9);
        }
        dist[0][0]=0;
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)->(a.w-b.w));
        q.offer(new pair(0,0,0));
        while(!q.isEmpty()){
            pair curr=q.poll();
            int row=curr.r;
            int col=curr.c;
            int cost=curr.w;
            if(row==rl-1&&col==cl-1)return cost;
            if(cost>dist[row][col])continue;
            for(int i=0;i<4;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0&&nr<rl&&nc>=0&&nc<cl){
                    int c=grid[row][col]==i+1?0:1;

                    if(dist[nr][nc]>c+dist[row][col]){
                        dist[nr][nc]=c+dist[row][col];
                        q.offer(new pair(nr,nc,dist[nr][nc]));
                    }
                }
            }
        }
        return dist[rl-1][cl-1];
    }
}