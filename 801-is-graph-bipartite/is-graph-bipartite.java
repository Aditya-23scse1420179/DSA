class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[]color=new int[n];
        for(int i=0;i<n;i++){
            if(color[i]!=0)continue;
            Queue<Integer>q=new LinkedList<>();
            q.offer(i);
            color[i]=1;
            while(!q.isEmpty()){
                int node=q.remove();
                for(int a:graph[node]){
                    if(color[a]==0){
                        color[a]=-color[node];
                        q.offer(a);
                    }else if(color[a]==color[node])return false;
                }
            }
        }
        return true;
    }
}