class Solution {
    public int findMin(int[] nums) {
        int min=(int)1e9;
        for(int a:nums){
            min=Math.min(a,min);
        }
        return min;
    }
}