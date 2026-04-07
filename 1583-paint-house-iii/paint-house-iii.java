class Solution {
    int m,n;
    int target;
    int []houses;
    int[][]cost;
    Integer[][][]dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.m=m;
        this.n=n;
        this.cost=cost;
        this.target=target;
        this.houses=houses;
        dp=new Integer[m+1][n+1][target+1];
        int ans=helper(0,0,0);
        return ans>=(int)1e9?-1:ans;
    }public int helper(int idx,int prev,int neighbour ){
        if(idx==m){
            if(target==neighbour)return 0;
            else return (int)1e9;
        } if(neighbour>target)return (int)1e9;
        if(dp[idx][prev][neighbour]!=null) return dp[idx][prev][neighbour];
        int ans=(int)1e9;
        if(houses[idx]!=0){
            int color=houses[idx];
            int ng = neighbour + (color != prev ? 1 : 0);
            ans =helper(idx+1,color,ng);
        }else{
            for(int i=1;i<=n;i++){
                int ng = neighbour+(i!=prev?1:0);
                int cc=cost[idx][i-1]+helper(idx+1,i,ng);
                ans=Math.min(ans,cc);
            }
        }
        return dp[idx][prev][neighbour]=ans;
    }
    
}