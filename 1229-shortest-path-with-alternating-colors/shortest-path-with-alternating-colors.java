class Solution {
    class pair{
        int node,dist,color;
        public pair(int node,int dist,int color){
            this.node=node;
            this.dist=dist;
            this.color=color;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] red, int[][] blue) {
        ArrayList<ArrayList<pair>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int []a:red){
            int u=a[0];
            int v=a[1];
            list.get(u).add(new pair(v,0,1));
        }
        for(int[]a:blue){
            int u=a[0];
            int v=a[1];
            list.get(u).add(new pair(v,0,2));
        } 
        Queue<pair>q=new LinkedList<>();
        int[]dist=new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[0]=0;
        boolean[][]visit=new boolean[n][3];
        q.offer(new pair(0,0,0));
        while(!q.isEmpty()){
            pair curr=q.poll();
            int u=curr.node;
            int w=curr.dist;
            int c=curr.color;
            visit[u][c]=true;
            for(pair a:list.get(u)){
                int nu=a.node;
                int nc=a.color;
                if(nc!=c&&visit[nu][nc]==false){
                    q.offer(new pair(nu,w+1,nc));
                    dist[nu]=Math.min(w+1,dist[nu]);
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            if(dist[i]==(int)1e9){
                dist[i]=-1;
            }
        }
        return dist;
    }
}