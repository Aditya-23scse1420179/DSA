class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;//2 ki power ke jitne bhi number hain sabke binary me bs ak 1 hota hai aur agar n se -1 lar denge to ulta hoga sab one hoga aur vo ak 1 0 hoga unka and humesa 0 dega 
    }
}