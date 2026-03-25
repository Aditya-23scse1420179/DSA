class Solution {
    class pair{
        int node,weight;
        public pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    static int[]dist;
    static int m;
    static int N;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        N=n;
        m=edges.length;
        ArrayList<ArrayList<pair>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int result=-1;
        int reach=(int)1e9;
        for(int[] a:edges){
            int u=a[0];
            int v=a[1];
            int w=a[2];
            list.get(u).add(new pair(v,w));
            list.get(v).add(new pair(u,w));
        }
        for(int start=0;start<n;start++){
            dist=new int[n];
            Arrays.fill(dist,(int)1e9);
            PriorityQueue<pair>q=new PriorityQueue<>((a,b)->Integer.compare(a.weight,b.weight));
            q.offer(new pair(start,0));
            dist[start]=0;
            while(!q.isEmpty()){
                pair curr=q.remove();
                int u=curr.node;
                int w=curr.weight;
                if(dist[u]<w)continue;
                for(pair a:list.get(u)){
                    int v=a.node;
                    int W=a.weight;
                    if(dist[v]>dist[u]+W){
                        dist[v]=dist[u]+W;
                        q.offer(new pair(v,dist[v]));
                    }
                }
            }int rechable=0;
            for(int i=0;i<n;i++){
                if(i!=start&&dist[i]<=distanceThreshold)rechable++;
            }
            if(rechable<=reach){
                reach=rechable;
                result=start;
            }
        }
        return result;
    }
}