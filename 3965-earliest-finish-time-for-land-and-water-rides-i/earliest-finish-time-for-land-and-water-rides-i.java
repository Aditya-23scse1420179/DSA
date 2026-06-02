class Solution {
    public int earliestFinishTime(int[] lST, int[] lD, int[] wST, int[] wD) {
        int min=(int)1e9;
        for(int i=0;i<lST.length;i++){
            for(int j=0;j<wST.length;j++){
                int l=lST[i]+lD[i];
                int t=Math.max(l,wST[j])+wD[j];

                int w=wST[j]+wD[j];
                int wt=Math.max(w,lST[i])+lD[i];
                min=Math.min(min,Math.min(t,wt));
            }
        }
        return min;
    }
}