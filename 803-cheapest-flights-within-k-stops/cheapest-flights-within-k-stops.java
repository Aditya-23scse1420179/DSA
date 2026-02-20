class Solution {
    class pair{
        int node,dist,stop;
        public pair(int node,int dist,int stop){
            this.node=node;
            this.dist=dist;
            this.stop=stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            list.get(u).add(new pair(v,w,0));
        }
        int[][]dist=new int[n][k+2];
        for(int[]a:dist){
            Arrays.fill(a,(int)1e9);
        }
        dist[src][0]=0;
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)-> Integer.compare(a.dist,b.dist));
        q.offer(new pair(src,0,0));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int u=curr.node;
            int w=curr.dist;
            int ss=curr.stop;
            if(u==dst)return w;
            if(ss>k)continue;
            
            for(pair a:list.get(u)){
                int nn=a.node;
                int W=a.dist;
                if(dist[nn][ss+1]>w+W){
                    dist[nn][ss+1]=w+W;
                    q.offer(new pair(nn,w+W,ss+1));
                }
            }
        }
        return -1;
    }
}