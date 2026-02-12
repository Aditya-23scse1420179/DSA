class Solution {
    static class pair{
        int node;
        long dist;
        public pair(int node,long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<pair>>list=new ArrayList<>();
        long[]distance=new long[n];
        Arrays.fill(distance,Long.MAX_VALUE);
        int[]ways=new int[n];
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            long w=roads[i][2];
            list.get(u).add(new pair(v,w));
            list.get(v).add(new pair(u,w));
        }
        ways[0]=1;
        distance[0]=0;
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));
        q.offer(new pair(0,0));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int cur=curr.node;
            long dis=curr.dist;
            if(distance[cur]<dis)continue;
            for(pair a:list.get(cur)){
                int v=a.node;
                long w=a.dist;
                if(distance[v]>distance[cur]+w){
                    distance[v]=distance[cur]+w;
                    ways[v]=ways[cur];
                    q.offer(new pair(v,distance[v]));
                }else if(distance[v]==distance[cur]+w){
                    ways[v]=(ways[v]+ways[cur])%1000000007;
                }
            }
        }
        return(int)ways[n-1];
    }
}