class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[]outdegree=new int[graph.length];
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            list.add(new ArrayList<>());
        }Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            outdegree[i]=graph[i].length;
            for(int a:graph[i]){
                list.get(a).add(i);
            }
        }for(int i=0;i<graph.length;i++){
            if(outdegree[i]==0){
                q.offer(i);
            }
        }ArrayList<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.remove();
            ans.add(curr);
            for(int a:list.get(curr)){
                outdegree[a]--;
                if(outdegree[a]==0){
                    q.offer(a);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}