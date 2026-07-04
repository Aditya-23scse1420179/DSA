class Solution {
    class pair{
        int n,w;
        public pair(int n,int w){
            this.n=n;
            this.w=w;
        }
    }
    int []parent;
    int[]rank;
    public int minScore(int n, int[][] roads) {
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        List<List<pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]a:roads){
            int u=a[0];
            int v=a[1];
            int w=a[2];
            adj.get(u).add(new pair(v,w));
            adj.get(v).add(new pair(u,w));
            if(u==1||u==n)union(u,v);
        }int ans=(int)1e9;
        boolean[]visit=new boolean[n+1];
        Queue<Integer>q=new LinkedList<>();
        q.offer(1);
        visit[1]=true;
        while(!q.isEmpty()){
            int c=q.poll();
            for(pair a:adj.get(c)){
                int d=a.w;
                ans=Math.min(ans,d);
                if(!visit[a.n]){
                    visit[a.n]=true;
                    q.offer(a.n);
                }
            }
        }
        return ans;
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public boolean union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py)return false;
        if(rank[px]>rank[py]){
            parent[py]=px;
        }else if(rank[py]>rank[px]){
            parent[px]=py;
        }else{
            parent[px]=py;
            rank[py]++;
        }
        return false;
    }
}