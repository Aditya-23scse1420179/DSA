class Solution {
    public int maxSatisfaction(int[] satisfy) {
        Arrays.sort(satisfy);
        int suff=0,sum=0;
        for(int i=satisfy.length-1;i>=0;i--){
            suff+=satisfy[i];
            if(suff<=0){
                break;
            }
            sum+=suff;
        }
        return sum;
    }
}