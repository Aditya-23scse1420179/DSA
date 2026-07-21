class Solution {
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n=graph.length;
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>path=new ArrayList<>();
        dfs(path,ans,graph,0);
        return ans;
    }public void dfs(List<Integer>path,List<List<Integer>>ans,int[][]graph,int src){
        path.add(src);
        if(src==n-1){
            ans.add(new ArrayList<>(path));

        }else{
            for(int a:graph[src]){
                dfs(path,ans,graph,a);
            }
        }
        path.remove(path.size()-1);//backtrack
    }
}