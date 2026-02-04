class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>>list=new ArrayList<>();
        int e=edges.length;
        for(int i=0;i<=n+1;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        boolean []visit=new boolean [n];
        Queue<Integer>q=new LinkedList<>();
        visit[source]=true;
        q.offer(source);
        while(!q.isEmpty()){
            int node=q.remove();
            for(int i:list.get(node)){
                if(visit[i]==false){
                    visit[i]=true;
                    q.offer(i);
                }
            }
        }
        return visit[destination];
    }
}