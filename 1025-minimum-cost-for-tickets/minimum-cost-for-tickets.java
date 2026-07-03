class Solution {
    Integer[]dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp=new Integer[days.length+1];
        return helper(0,days,costs);
    }public int helper(int idx,int[]days,int[]costs){
        if(idx>=days.length)return 0;
        if(dp[idx]!=null)return dp[idx];
        int trip1=costs[0]+helper(idx+1,days,costs);
        int i=idx;
        while(i<days.length&&days[i]<=days[idx]+6)i++;
        int trip2=costs[1]+helper(i,days,costs);
        i=idx;
        while(i<days.length&&days[i]<=days[idx]+29)i++;
        int trip3=costs[2]+helper(i,days,costs);
        return dp[idx]=Math.min(trip1,Math.min(trip2,trip3));
    }
}