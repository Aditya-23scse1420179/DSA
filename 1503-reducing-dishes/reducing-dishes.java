class Solution {
    Integer[][]dp;
    public int maxSatisfaction(int[] a) {
        Arrays.sort(a);
        dp=new Integer[a.length+1][a.length+1];
       return helper(a,1,0);
    }
    public int helper(int a[],int time,int ind){
        if(ind==(a.length))return 0;
        if(dp[time][ind]!=null)return dp[time][ind];
          
        int pick=time*a[ind]+helper(a,time+1,ind+1);
        int notpick=helper(a,time,ind+1);
        return dp[time][ind]=Math.max(pick,notpick);
    }
}