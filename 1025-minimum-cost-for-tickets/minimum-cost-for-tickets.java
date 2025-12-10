class Solution {
    public int helper(int []days,int []costs,int idx,Integer[]dp){
        if(idx>=days.length)return 0;
        if(dp[idx]!=null)return dp[idx];
        int trip1=costs[0]+helper(days,costs,idx+1,dp);
        int i = idx;
        while (i < days.length && days[i] <= days[idx] + 6) i++;
        int trip2=costs[1]+helper(days,costs,i,dp);
        i = idx;
        while (i < days.length && days[i] <= days[idx] + 29) i++;
        int trip3=costs[2]+helper(days,costs,i,dp);
        return dp[idx]=Math.min(trip1,Math.min(trip2,trip3));

    }
    public int mincostTickets(int[] days, int[] costs) {
        Integer[]dp= new Integer[days.length];
        return helper(days,costs,0,dp);
    }
}