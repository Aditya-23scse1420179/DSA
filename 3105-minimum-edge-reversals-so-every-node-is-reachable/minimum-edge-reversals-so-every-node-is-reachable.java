class Solution {
    static int N;
    static List<int[]>[]tree;
    static int[]dist;
    static int []ans;
    public int[] minEdgeReversals(int n, int[][] edges) {
        N=n;
        dist=new int[N];
        ans=new int[N];
        tree=new ArrayList[N];
        for(int i=0;i<n;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            tree[u].add(new int[]{v,0});
            tree[v].add(new int[]{u,1});//reversal 
        }
        dfs(0,-1);
        ans[0]=dist[0];
        reRoot(0,-1);
        return ans;
    }public void dfs(int node,int parent){
        for(int[]child:tree[node]){
            int v=child[0];
            int cost=child[1];
            if(v==parent)continue;
            dfs(v,node);
            dist[node]+=dist[v]+cost;
        }
    }public void reRoot(int node,int parent){
        for(int []child:tree[node]){
            int v=child[0];
            int cost=child[1];
            if(v==parent)continue;
            if(cost==0){
                ans[v]=ans[node]+1;
            }else ans[v]=ans[node]-1;
            reRoot(v,node);
        }
    }
}