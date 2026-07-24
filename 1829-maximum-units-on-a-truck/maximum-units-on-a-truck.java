class Solution {
    public int maximumUnits(int[][] boxTypes, int ts) {
        int n=boxTypes.length;
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int ans=0;
        for(int i=0;i<n;i++){
            if(ts>=boxTypes[i][0]){
                ans+=boxTypes[i][1]*boxTypes[i][0];
                ts-=boxTypes[i][0];
            }
            else{
                ans+=ts*boxTypes[i][1];
                break;
            }
        }
        return ans;
    }
}