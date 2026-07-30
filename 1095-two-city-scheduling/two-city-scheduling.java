class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n=costs.length;
        Arrays.sort(costs,(a,b)->{//sort on the basis of costs
            return (a[0]-a[1])-(b[0]-b[1]);
        });
        int ans=0;
        for(int i=0;i<n/2;i++){
            ans+=costs[i][0];
        }
        for(int i=n/2;i<n;i++){
            ans+=costs[i][1];
        }
        return ans;


    }
}