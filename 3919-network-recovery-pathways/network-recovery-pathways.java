class Solution {
    class pair{
        int r,w;
        public pair(int r,int w){
            this.r=r;
            this.w=w;
        }
    }
    List<List<pair>>adj;
    boolean[] on;
    long K;
    List<Integer>top;
    int n;
    long INF=Long.MAX_VALUE;
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        n=online.length;
        this.on=online;
        this.K=k;
        int[]indegree=new int[n];
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int maxe=0;
        for(int[]a:edges){
            int u=a[0];
            int v=a[1];
            int w=a[2];
            adj.get(u).add(new pair(v,w));
            indegree[v]++;
            maxe=Math.max(maxe,w);
        }Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.offer(i);
        }
        top=new ArrayList<>();
        while(!q.isEmpty()){
            int u=q.poll();
            top.add(u);
            for(pair a:adj.get(u)){
                int v=a.r;
                indegree[v]--;
                if(indegree[v]==0)q.offer(v);
            }
        }
        long l=0,h=maxe;
        int ans=-1;
        while(l<=h){
            long mid=l+(h-l)/2;
            if(helper(mid)){
                ans=(int)mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }public boolean helper(long mid){
        long[]dp=new long[n];
        Arrays.fill(dp,INF);
        dp[0]=0;
        for(int u:top){
            if(dp[u]==INF)continue;
            if(u!=0&&u!=n-1&&!on[u])continue;
            for(pair e:adj.get(u)){
                int v=e.r;
                int x=e.w;
                if(x<mid)continue;
                if(v!=n-1&&!on[v])continue;
                dp[v]=Math.min(dp[v],dp[u]+x);
            }
        }
        return dp[n-1]<=K;
    }
}