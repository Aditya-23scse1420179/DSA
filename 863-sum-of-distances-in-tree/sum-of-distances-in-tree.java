class Solution {
    List<Integer>[]tree;
    static int[]dist;
    static int[]subtree;
    int N;
    int []ans;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N=n;
        tree=new ArrayList[n];
        dist=new int[n];
        ans=new int[n];
        subtree=new int[n];
        for(int i=0;i<n;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            tree[a].add(b);
            tree[b].add(a);
        }      
        dfs(0,-1);
        ans[0]=dist[0];
        //re routing
        reRoot(0,-1);
        return ans;
    }public void dfs(int node,int parent){
        subtree[node]=1;
        for(int child:tree[node]){
            if(child==parent)continue;
            dfs(child,node);
            subtree[node]+=subtree[child];
            dist[node]+=dist[child]+subtree[child];
        }
    }public void reRoot(int node,int parent){
        for(int child:tree[node]){
            if(child==parent)continue;
            ans[child]=ans[node]+N-2*subtree[child];
            reRoot(child,node);
        }
    }
}