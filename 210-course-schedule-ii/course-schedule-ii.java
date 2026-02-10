class Solution {
    public int[] findOrder(int V, int[][] pre) {
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        ArrayList<Integer>ans=new ArrayList<>();
        int[]indegree=new int[V];
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }for(int i=0;i<pre.length;i++){
            int u=pre[i][0];
            int v=pre[i][1];
            list.get(v).add(u);
            indegree[u]++;
        }for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }while(!q.isEmpty()){
            int curr=q.remove();
            ans.add(curr);
            for(int a:list.get(curr)){
                indegree[a]--;
                if(indegree[a]==0){
                    q.offer(a);
                }
            }
        }if(ans.size()!=V)return (new int[]{});
        int[]arr=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            arr[i]=ans.get(i);
        }return arr;
    }
}