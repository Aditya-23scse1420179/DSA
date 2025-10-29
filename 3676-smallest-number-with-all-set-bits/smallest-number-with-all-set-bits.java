class Solution {
    public int smallestNumber(int n) {
        int bitLength =Integer.SIZE- Integer.numberOfLeadingZeros(n);
        return (1<<bitLength) -1;
    }
}
