class Solution {
    public int minMoves(int[] nums) {
        int min=(int)1e9;
        for(int a:nums){
            min=Math.min(a,min);
        }
        int ans=0;
        for(int b:nums){
            ans+=Math.abs(min-b);
        }
        return ans;
    }
}