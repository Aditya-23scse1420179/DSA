class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int []color=new int[n];
        for(int i=0;i<n;i++){
            if(color[i]==0){//if uncolored then proceed
                Queue<Integer>q=new LinkedList<>();
                q.offer(i);
                color[i]=1;
                while(!q.isEmpty()){
                    int node=q.remove();
                    for(int a:graph[node]){
                        if(color[a]==0){//check for color 
                            color[a]=-color[node];//reverse of color 
                            q.offer(a);
                        }else if(color[a]==color[node])return false;//same color 
                    }
                }
            }
        }
        return true;
    }
}