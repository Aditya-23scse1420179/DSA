class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxl=-(int)1e9,maxp=0;
        for(int b:lights){
            maxl=Math.max(maxl,b);
        }
        for(int a:arrivalTime){
            int r=a%period;
            if(r>=maxl){
                maxp=Math.max(maxp,period-r);
            }
        }
        return maxp;
    }
}