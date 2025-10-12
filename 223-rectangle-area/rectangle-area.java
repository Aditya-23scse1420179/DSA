class Solution {
    public int computeArea(int A,int B,int C,int D,int E,int F,int G,int H){
        long area1=(long)(C- A)*(D-B);
        long area2= (long)(G -E)*(H -F);
        long overlapX =Math.max(0, Math.min(C,G)- Math.max(A,E));
        long overlapY =Math.max(0,Math.min(D,H)-Math.max(B,F));
        long overlapArea= overlapX*overlapY;
        long total =area1+area2-overlapArea;
        return(int)total;
    }
}
