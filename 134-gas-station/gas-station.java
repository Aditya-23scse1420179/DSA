class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=cost.length;
        int total=0,curr=0,start=0;
        for(int i=0;i<n;i++){
            int gain=gas[i]-cost[i];
            total+=gain;
            curr+=gain;
            if(curr<0){
                curr=0;
                start=i+1;
            }
        }
        if(total>=0){
            return start;
        }
        return -1;
    }
}