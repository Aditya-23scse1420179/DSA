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
        Queue<Integer>q=new LinkedList<>();
        boolean []visit=new boolean [n];
        visit[source]=true;
        q.offer(source);
        while(!q.isEmpty()){
            int node=q.remove();
            for(int a:list.get(node)){
                if(visit[a]==false){
                    visit[a]=true;
                    q.offer(a);
                }
            }
        }
        if(visit[destination]==true)return true;
        return false;
    }
}