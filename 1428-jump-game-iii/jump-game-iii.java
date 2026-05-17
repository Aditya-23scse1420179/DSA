class Solution {
    boolean[]visit;
    public boolean canReach(int[] arr, int start) {
        visit=new boolean[arr.length+1];
        return dfs(start,arr);
    }public boolean dfs(int idx,int[]arr){
        if(idx<0||idx>=arr.length)return false;
        if(visit[idx]==true)return false;
        if(arr[idx]==0)return true;
        visit[idx]=true;
        int fwd=idx+arr[idx];
        int rwd=idx-arr[idx];
        return dfs(fwd,arr)||dfs(rwd,arr);
    }
}