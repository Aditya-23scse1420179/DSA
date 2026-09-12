class Solution {
    Integer[][]dp;
    public int maxTwoEvents(int[][] events) {
        dp=new Integer[events.length+1][3];
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        return helper(0,events,0);
    }public int helper(int idx,int[][]events,int count){
        if(count==2||idx>=events.length)return 0;
        if(dp[idx][count]!=null)return dp[idx][count];
        int ntake=helper(idx+1,events,count);
        int id=bs(idx,events,events[idx][1]);
        int take=events[idx][2]+helper(id,events,count+1);
        return dp[idx][count]=Math.max(take,ntake);
    }public int bs(int idx,int[][]events,int end){
        int ans=events.length,l=idx+1,h=events.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(events[mid][0]>end){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}