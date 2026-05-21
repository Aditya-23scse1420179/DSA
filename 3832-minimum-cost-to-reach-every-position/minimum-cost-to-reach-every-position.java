class Solution {
    public int[] minCosts(int[] cost) {
        int n=cost.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,cost[i]);
            cost[i]=min;
        }
        return cost;
    }
}