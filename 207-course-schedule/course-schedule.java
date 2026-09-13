class Solution {
    public boolean canFinish(int n, int[][] p) {
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        int[]indegree=new int[n];
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[]a:p){
            int u=a[0];
            int v=a[1];
            list.get(u).add(v);
            indegree[v]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)q.offer(i);
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            ans.add(curr);
            for(int a:list.get(curr)){
                indegree[a]--;
                if(indegree[a]==0)q.offer(a);
            }
        }
        return ans.size()==n;
    }
}