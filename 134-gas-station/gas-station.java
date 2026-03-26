class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas=0,totalcost=0;
        for(int a:gas){
            totalgas+=a;
        }
        for(int c:cost){
            totalcost+=c;
        }
        if(totalgas<totalcost)return -1;
        int start=0,tel=0;
        for(int i=0;i<gas.length;i++){
            tel+=gas[i]-cost[i];
            if(tel<0){
                start=i+1;
                tel=0;
            }
        }
        return start;
    }
}