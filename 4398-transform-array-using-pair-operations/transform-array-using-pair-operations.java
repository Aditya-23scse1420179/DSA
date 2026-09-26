class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long s=0,d=0;
        for(int i=0;i<source.length;i++){
            s+=source[i];
            d+=target[i];
        }
        return s==d;
    }
}