class Solution {
    public int largestAltitude(int[] gain) {
        int height =0;
        int curr =0;
        for(int x:gain){
            curr+=x;
            if(curr>height){
                height=curr;
            }
        }
        return height;
    }
}