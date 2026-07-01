class Solution {
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    int[][]dist;
    int rl,cl;
    class Node{
        int safe,row,col;
        public Node(int safe,int row,int col){
            this.safe=safe;
            this.row=row;
            this.col=col;
        }
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        rl=grid.size();
        cl=grid.get(0).size();
        Queue<Node>q=new LinkedList<>();
        dist=new int[rl][cl];
        for(int[]a:dist){
            Arrays.fill(a,(int)1e9);
        }
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(grid.get(i).get(j)==1){
                    dist[i][j]=0;
                    q.offer(new Node(0,i,j));
                }
            }
        }
        bfs(q);
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->b.safe-a.safe);
        pq.offer(new Node(dist[0][0],0,0));
        boolean[][]vis=new boolean[rl][cl];
        while(!pq.isEmpty()){
            Node curr=pq.poll();
            int safe=curr.safe;
            int r=curr.row;
            int c=curr.col;
            if(r==rl-1&&c==cl-1)return safe;
            if(vis[r][c])continue;
            vis[r][c]=true;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nr<rl&&nc>=0&&nc<cl&&!vis[nr][nc]){
                    int newSafe=Math.min(safe,dist[nr][nc]);
                    pq.offer(new Node(newSafe,nr,nc));
                }
            }
        }
        return 0; 
    }public void bfs(Queue<Node>q){
        while(!q.isEmpty()){
            Node curr=q.poll();
            int nr=curr.row;
            int nc=curr.col;
            for(int i=0;i<4;i++){
                int nnr=nr+dr[i];
                int nnc=nc+dc[i];
                if(nnr>=0 && nnr<rl && nnc>=0 && nnc<cl){
                    if(dist[nnr][nnc]>dist[nr][nc]+1){
                        dist[nnr][nnc]=dist[nr][nc]+1;
                        q.offer(new Node(0,nnr,nnc));
                    }
                }
            }
        }
    }
}