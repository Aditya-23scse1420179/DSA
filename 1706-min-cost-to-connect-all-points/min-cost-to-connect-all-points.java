class Solution {
    class pair{
        int node;
        int cost;
        public pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        boolean[]visit=new boolean[n];
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)->a.cost-b.cost);
        q.offer(new pair(0,0));
           int ans=0;
        while(!q.isEmpty()){
            pair curr=q.remove();
            int u=curr.node;
            int w=curr.cost;
            
            if(visit[u]==true)continue;//pahle se ho to continue karo
            if(!visit[u]){
                ans+=w;// naya ho to add karo 
                visit[u]=true;//aur true mark karo 
            }

            

            for(int i=0;i<n;i++){
                if(!visit[i]){
                    int cost=Math.abs(points[u][0]-points[i][0])+
                            Math.abs(points[u][1]-points[i][1]);
                            q.offer(new pair(i,cost));
                }
            }
        }
        return ans;
    }
}