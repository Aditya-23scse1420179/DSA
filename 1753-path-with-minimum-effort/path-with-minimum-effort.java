class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static class pair{
        int row;
        int col;
        int dist;
        public pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)->Integer.compare(a.dist,b.dist));
        int n=heights.length;
        int m=heights[0].length;
        int [][]distance=new int[n][m];
        for(int []a:distance){
            Arrays.fill(a,(int)1e9);
        }
        distance[0][0]=0;
        q.offer(new pair(0,0,0));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            int w=curr.dist;
            if(w>distance[r][c])continue;
            if(r==n-1&&c==m-1)return w;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m){
                    int newEfforts=Math.max(w,Math.abs(heights[nr][nc]-heights[r][c]));
                    if(newEfforts<distance[nr][nc]){
                        distance[nr][nc]=newEfforts;
                        q.offer(new pair(nr,nc,newEfforts));
                    }
                }
            }
        }
        return -1;
    }
}