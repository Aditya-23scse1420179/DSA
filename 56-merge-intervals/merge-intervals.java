class Solution {
    public int[][] merge(int[][] intervals) {
        int[][]ans=new int[intervals.length][2];
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        int idx=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end=Math.max(intervals[i][1],end);
            }
            else{
                ans[idx][0]=start;
                ans[idx][1]=end;
                start=intervals[i][0];
                end=intervals[i][1];
                idx++;
            }
        }
        ans[idx][0]=start;
        ans[idx][1]=end;
        return Arrays.copyOf(ans,idx+1);
    }
}