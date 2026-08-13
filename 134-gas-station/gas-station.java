class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tg=0,tt=0;
        for(int i=0;i<gas.length;i++){
            tg+=gas[i];
            tt+=cost[i];
        }
        if(tt>tg)return -1;
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