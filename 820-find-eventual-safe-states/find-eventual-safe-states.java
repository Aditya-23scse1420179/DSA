class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int m=graph[0].length;
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        int[]outdegree=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            list.add(new ArrayList<>());
        }for(int i=0;i<graph.length;i++){
            outdegree[i]=graph[i].length;
            for(int a:graph[i]){
                list.get(a).add(i);
            }
        }Queue<Integer>q=new LinkedList<>();
        ArrayList<Integer>path=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(outdegree[i]==0){
                q.offer(i);
            }
        }while(!q.isEmpty()){
            int curr=q.remove();
            path.add(curr);
            for(int a:list.get(curr)){
                outdegree[a]--;
                if(outdegree[a]==0){
                    q.offer(a);
                }
            }
        }Collections.sort(path);
        return path;
    }
}