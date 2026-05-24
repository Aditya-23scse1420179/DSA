class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean[]visit=new boolean[arr.length+1];
        Queue<Integer>q=new LinkedList<>();
        q.offer(start);
        visit[start]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            if(arr[curr]==0)return true;
            int forward=curr+arr[curr];
            int backward=curr-arr[curr];
            if(forward<n&&!visit[forward]){
                visit[forward]=true;
                q.offer(forward);
            }
            if(backward>=0&&!visit[backward]){
                visit[backward]=true;
                q.offer(backward);
            }
        }
        return false;
    }
}