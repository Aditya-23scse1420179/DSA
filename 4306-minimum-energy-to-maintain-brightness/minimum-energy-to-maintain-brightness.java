class Solution {
    public long minEnergy(int n, int bri, int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        long ans=0;
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end+1){
                end=Math.max(end,intervals[i][1]);
            }
            else{
                ans+=end-start+1;
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        ans+=end-start+1;
        return ((bri+2)/3)*ans;
    }
}