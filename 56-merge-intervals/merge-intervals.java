class Solution {
    public int[][] merge(int[][] intervals) {
        int n =intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[][]ans=new int[intervals.length][2];
        int idx=0;
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }else{
                ans[idx][0]=start;
                ans[idx][1]=end;
                start=intervals[i][0];
                end=intervals[i][1];
                idx++;
            }
        }
        ans[idx][0]=start;
        ans[idx][1]=end;
        return Arrays.copyOfRange(ans,0,idx+1);
    }

}