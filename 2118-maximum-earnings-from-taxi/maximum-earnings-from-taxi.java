class Solution {
    Long[]dp;
    public long maxTaxiEarnings(int n, int[][] rides) {
        dp=new Long[rides.length];
        Arrays.sort(rides,(a,b)->a[0]-b[0]);
        return helper(rides,0);
    }public long helper(int[][]rides,int idx){
        if(idx>=rides.length)return 0;
        if(dp[idx]!=null)return dp[idx];
        long ntake=helper(rides,idx+1);
        int id=bs(rides,idx,rides[idx][1]);
        long take=(rides[idx][1]-rides[idx][0]+rides[idx][2])+helper(rides,id);
        return dp[idx]=Math.max(ntake,take);
    }public int bs(int[][]rides,int id,int end){
        int low=id+1,high=rides.length-1,ans=rides.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(rides[mid][0]>=end){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}