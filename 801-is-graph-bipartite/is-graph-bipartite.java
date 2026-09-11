class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[]col=new int[n];
        for(int i=0;i<n;i++){
            if(col[i]==0){
                Queue<Integer>q=new LinkedList<>();
                col[i]=1;
                q.offer(i);
                while(!q.isEmpty()){
                    int node=q.poll();
                    for(int a:graph[node]){
                        if(col[a]==0){
                            col[a]-=col[node];
                            q.offer(a);
                        }else if(col[a]==col[node])return false;
                    }
                }
            }
        }
        return true;
    }
}