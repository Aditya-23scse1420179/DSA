class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean []visit=new boolean[rooms.size()];
        // Queue<Integer>q=new LinkedList<>();
        // visit[0]=true;
        // q.offer(0);
        // while(!q.isEmpty()){
        //     int node=q.remove();
        //     for(int i:rooms.get(node)){
        //         if(visit[i]==false){
        //             visit[i]=true;
        //             q.offer(i);
        //         }
        //     }
        // }
        dfs(rooms,0,visit);
        for(boolean b:visit){
            if(b==false)return false;
        }
        return true;
    }public void dfs(List<List<Integer>>rooms,int src,boolean[]visit){
        visit[src]=true;
        for(int a:rooms.get(src)){
            if(visit[a]==false){
                dfs(rooms,a,visit);
            }
        }
    }
}