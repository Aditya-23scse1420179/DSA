class Solution {
    public int findRadius(int[] h, int[] heat) {
        Arrays.sort(heat);
        Arrays.sort(h);
        int r=0,j=0;
        for(int a:h){
            while(j<heat.length-1&&Math.abs(a-heat[j+1])<=Math.abs(a-heat[j])){
                j++;
            }
            int dist=Math.abs(a-heat[j]);
            r=Math.max(r,dist);
        }
        return r;
    }
}