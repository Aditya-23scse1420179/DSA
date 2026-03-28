class Solution {
    public int minMoves2(int[] nums) {
        int median=0;
        int n=nums.length;
        Arrays.sort(nums);
    
        median=nums[n/2];
        
        int opp=0;
        for(int a:nums){
            opp+=Math.abs(a-median);
        }
        return opp;

    }
}