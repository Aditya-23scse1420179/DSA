class Solution {
    int ans=0;
    public int eraseOverlapIntervals(int[][] inter) {
        Arrays.sort(inter,(a,b)->a[1]-b[1]);
        int prev=inter[0][1];
        for(int i=1;i<inter.length;i++){
            if(inter[i][0]<prev){
                ans++;
            }else{
                prev=inter[i][1];
            }
        }
        return ans;
    }
}