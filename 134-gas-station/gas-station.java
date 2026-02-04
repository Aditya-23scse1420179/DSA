class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=cost.length;
        int totalgas=0,totalcost=0,currgas=0,start=0;
        for(int i=0;i<n;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];
            currgas+=gas[i]-cost[i];
            if(currgas<0){
                currgas=0;
                start=i+1;
            }
        }
        if(totalgas<totalcost)return -1;
        return start;
    }
}
