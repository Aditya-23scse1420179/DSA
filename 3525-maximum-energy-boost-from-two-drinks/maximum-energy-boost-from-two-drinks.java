class Solution {
    public long maxEnergyBoost(int[] eA, int[] eB) {
        int n=eA.length;
        long[]dpA=new long[eA.length];
        long[]dpB=new long[eB.length];
        dpA[0]=eA[0];
        dpB[0]=eB[0];
        for(int i=1;i<n;i++){
            dpA[i]=dpA[i-1]+eA[i];
            dpB[i]=dpB[i-1]+eB[i];
            if (i > 1) 
            {
                dpA[i] = Math.max(dpA[i], dpB[i-2] + eA[i]);
                dpB[i] = Math.max(dpB[i], dpA[i-2] + eB[i]);
            }

        }
        return Math.max(dpA[n-1],dpB[n-1]);
    }
}