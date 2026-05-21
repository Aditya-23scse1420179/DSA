class Solution {
    public int[] minCosts(int[] cost) {
        int n=cost.length;
        int[]arr=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,cost[i]);
            arr[i]=min;
        }
        return arr;
    }
}