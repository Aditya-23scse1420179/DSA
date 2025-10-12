class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] count = new int[10];
        while (n>0) {
            int d=n%10;
            count[d]++;
            n/= 10;
        }
        int minFreq=Integer.MAX_VALUE;
        int ans=-1;
        for (int d=0;d<=9;d++) {
            if (count[d]>0&&count[d]<minFreq) {
                minFreq=count[d];
                ans=d;
            }
        }
        return ans;
    }
}
