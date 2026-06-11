class Solution {
     List<List<Integer>>adj;
    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length+1;
        adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []a:edges){
            int u=a[0];
            int v=a[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int dept=dfs(1,-1);
        long res=1;
        for(int i=1;i<dept;i++){
            res=(res*2)%1000000007;
        }
        return (int)res;
    }public int dfs(int node,int parent){
        int depth=0;
        for(int a:adj.get(node)){
            if(a==parent)continue;
            depth=Math.max(depth,1+dfs(a,node));
        }
        return depth;
    }
}