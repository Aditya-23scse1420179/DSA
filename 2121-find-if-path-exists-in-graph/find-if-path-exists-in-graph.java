class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<=n+1;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        boolean []visit=new boolean[n];
        dfs(list,source,visit);
        if(visit[destination]==true)return true;
        return false;
    }public void dfs(ArrayList<ArrayList<Integer>>list,int source,boolean []visit){
        visit[source]=true;
        for(int a:list.get(source)){
            if(visit[a]==false){
                dfs(list,a,visit);
            }
        }
    }
}