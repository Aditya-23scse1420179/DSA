class Solution {
    static int []dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    class pair{
        int row,col,dist;
        public pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][]dist=new int[n][m];
        for(int[]a:dist){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)->Integer.compare(a.dist,b.dist));
        q.offer(new pair(0,0,0));
        dist[0][0]=0;
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            int w=curr.dist;
            if(r==n-1&&c==m-1)return w; 
            if(dist[r][c]<w)continue;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr<0||nr>=n||nc<0||nc>=m)continue;//agar >=0 to and condition 
                int d=Math.max(w,Math.abs(heights[nr][nc]-heights[r][c]));
                if(d<dist[nr][nc]){
                    dist[nr][nc]=d;
                    q.offer(new pair(nr,nc,dist[nr][nc]));
                }
            }
        }
        return -1;
    }
}