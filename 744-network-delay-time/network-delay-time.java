class Solution {
    class pair{
        int v,dist;
        public pair(int v,int dist){
            this.v=v;
            this.dist=dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<pair>>list=new ArrayList<>();
        int[]distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k]=0;
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int[]a:times){
            int u=a[0];
            int v=a[1];
            int d=a[2];
            list.get(u).add(new pair(v,d));

        }
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)->Integer.compare(a.dist,b.dist));
        q.offer(new pair(k,0));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int node=curr.v;
            int dis=curr.dist;
            if(distance[node]<dis)continue;
            for(pair a:list.get(node)){
                int r=a.v;
                int w=a.dist;
                if(distance[r]>dis+w){
                    distance[r]=dis+w;
                    q.offer(new pair(r,distance[r]));
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(distance[i]>=Integer.MAX_VALUE)return -1;
            ans=Math.max(ans,distance[i]);
        }
        return ans;
    }
}