class Solution {
    public boolean checkOverlap(int radius, int xc, int yc, int x1, int y1, int x2, int y2) {
        int x=Math.max(x1,Math.min(xc,x2))-xc;
        int y=Math.max(y1,Math.min(yc,y2))-yc;
        return x*x+y*y<=radius*radius;
    }
}