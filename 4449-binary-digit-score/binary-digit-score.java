class Solution {
    public int calculateScore(int a, int b) {
        int A=Integer.bitCount(a);
        int B=Integer.bitCount(b);
        if(A>=B)return A*B;
        else return B/A;
    }
}