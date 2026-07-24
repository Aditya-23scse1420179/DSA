class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n==1)return s;
        long u=(n-1+1)/2;
        long max=s+u*(long)m-(u-1);
        long u2=(n-1)/2;
        long max2=s+u2*(long)m-u2;
        return Math.max(max,max2);
    }
}