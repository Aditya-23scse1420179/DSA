class Solution {
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    class pair{
        int safe,row,col;
        public pair(int safe,int row,int col){
            this.safe=safe;
            this.row=row;
            this.col=col;
        }
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Queue<pair>q=new LinkedList<>();
        int rl=grid.size();
        int cl=grid.get(0).size();
        int[][]dist=new int[rl][cl];
        for(int[]a:dist){
            Arrays.fill(a,(int)1e9);
        }
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(grid.get(i).get(j)==1){
                    dist[i][j]=0;
                    q.offer(new pair(0,i,j));
                }
            }
        }
        while(!q.isEmpty()){
            pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nr<rl&&nc>=0&&nc<cl){
                    if(dist[nr][nc]>dist[r][c]+1){
                        dist[nr][nc]=dist[r][c]+1;
                        q.offer(new pair(0,nr,nc));
                    }
                }
            }
        }
        PriorityQueue<pair>qu=new PriorityQueue<>((a,b)->Integer.compare(b.safe,a.safe));
        boolean[][]visit=new boolean[rl][cl];
        qu.offer(new pair(dist[0][0],0,0));
        while(!qu.isEmpty()){
            pair curr=qu.poll();
            int s=curr.safe;
            int r=curr.row;
            int c=curr.col;
            if(r==rl-1&&c==cl-1)return s;
            if(visit[r][c])continue;
            visit[r][c]=true;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nr<rl&&nc>=0&&nc<cl&&!visit[nr][nc]){
                    int nsafe=Math.min(s,dist[nr][nc]);
                    qu.offer(new pair(nsafe,nr,nc));
                }
            }
        }
        return 0;
    }
}