class Solution {
    class pair{
        int node,dist,stop;
        public pair(int node,int dist,int stop){
            this.node=node;
            this.dist=dist;
            this.stop=stop;
        }
    }
    int rl;
    int cl;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        rl=flights.length;
        cl=flights[0].length;
        int[][] dist=new int[n][k+2];
        for(int[]a:dist){
            Arrays.fill(a,(int)1e9);
        }
        dist[src][0]=0;
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)->Integer.compare(a.dist,b.dist));
        ArrayList<ArrayList<pair>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            list.get(u).add(new pair(v,w,0));
        }
        q.offer(new pair(src,0,0));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int nn=curr.node;
            int d=curr.dist;
            int s=curr.stop;
            if(nn==dst)return d;
            if(s>k)continue;
            for(pair a:list.get(nn)){
                int u=a.node;
                int D=a.dist;
                if(dist[u][s+1]>d+D){
                    dist[u][s+1]=d+D;
                    q.offer(new pair(u,d+D,s+1));
                }
            }
        }
        return -1;

    }
}