class Solution {
    public int minMoves(int[] nums) {
        int max=0;
        for(int x:nums){
            max=Math.max(max,x);
        }
        int sum=0;
        for(int a:nums){
            sum+=(max-a);
        }
        return sum;
        
    }
}