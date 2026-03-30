class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int min=(int)1e9;
        for(int a:nums){
            min=Math.min(min,a);
        }
        int ans=0;
        for(int a:nums){
            ans+=a-min;
        }
        return ans;
    }
}