class Solution {
    class pair{
        int i,j,score;
        public pair(int i,int j,int score){
            this.i=i;
            this.j=j;
            this.score=score;
        }
    }
    int[]dr={-1,0,-1};
    int[]dc={0,-1,-1};
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        Queue<pair>q=new LinkedList<>();
        int[][]dist=new int[n][n];
        for(int[]a:dist){
            Arrays.fill(a,-1);
        }
        int[][]count=new int[n][n];
        q.offer(new pair(n-1,n-1,0));
        dist[n-1][n-1]=0;
        count[n-1][n-1]=1;
        while(!q.isEmpty()){
            pair curr=q.poll();
            for(int d=0;d<3;d++){
                int r=curr.i+dr[d];
                int c=curr.j+dc[d];
                if(r<0||r>=n||c<0||c>=n)continue;
                char ch=board.get(r).charAt(c);
                if(ch=='X')continue;
                int val=ch=='E'?0:ch-'0';
                int score=val+curr.score;
                if(score>dist[r][c]){
                    dist[r][c]=score;
                    count[r][c]=count[curr.i][curr.j];
                    q.offer(new pair(r,c,dist[r][c]));

                }else if(score==dist[r][c]){
                    count[r][c]=(count[r][c]+count[curr.i][curr.j])%1000000007;;
                }
            }
        }
        if(dist[0][0]==-1)return new int[]{0,0};
        return new int[]{dist[0][0],count[0][0]};
    }
}