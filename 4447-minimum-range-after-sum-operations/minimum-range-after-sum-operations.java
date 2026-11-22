class Solution {
    public int minRange(int a, int b, int c) {
        int x=Math.min(a,Math.min(b,c));
        int z=Math.max(a,Math.max(b,c));
        int y=a+b+c-x-z;
        return Math.min(z-x,y);
    }
}