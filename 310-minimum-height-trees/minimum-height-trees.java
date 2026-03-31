class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)return Arrays.asList(0);
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int[]indegree=new int[n];
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
            indegree[v]++;
            indegree[u]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==1){
                q.offer(i);
            }
        }
        int node=n;
        while(node>2){
            int size=q.size();
            node-=size;
            while(size-->0){
                int curr=q.remove();
                for(int nde:list.get(curr)){
                    indegree[nde]--;
                    if(indegree[nde]==1){
                        q.offer(nde);
                    }
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.remove());
        }
        return ans;
    }
}