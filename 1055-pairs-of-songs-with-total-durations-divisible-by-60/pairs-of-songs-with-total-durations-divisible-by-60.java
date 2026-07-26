class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int count=0;
        for (int t:time) {
            int rem=t%60;
            int comp=(60-rem)%60;
            count+=remainders[comp];
            remainders[rem]++;
        }
        return count;
    }
}