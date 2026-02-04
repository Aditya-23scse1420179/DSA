class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        Queue<Integer>q=new LinkedList<>();
        boolean[]visit=new boolean[n];
        visit[0]=true;
        q.offer(0);
        while(!q.isEmpty()){
            int node =q.remove();
            for(int a:rooms.get(node)){
                if(visit[a]==false){
                    visit[a]=true;
                    q.offer(a);
                }
            }
        }for(boolean b:visit){
            if(b==false)return false;
        }return true;
    }
}