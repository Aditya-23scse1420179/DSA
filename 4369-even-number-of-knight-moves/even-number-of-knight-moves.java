class Solution {
    public boolean canReach(int[] start, int[] target) {
        int dis=Math.abs(start[0]-target[0])+Math.abs(start[1]-target[1]);
        return dis%2==0?true:false;
    }
}