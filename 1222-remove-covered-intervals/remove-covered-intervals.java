class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[][]ans=new int[intervals.length][2];
        int start=intervals[0][0];
        int end=intervals[0][1];
        int idx=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][1]<=end){
                continue;
            }else{
                ans[idx][0]=start;
                ans[idx][1]=end;
                idx++;
                start=intervals[i][0];
                end=intervals[i][1];
                
            }

        }
        ans[idx][0]=start;
        ans[idx][1]=end;
        idx++;

        return idx;
    }
}