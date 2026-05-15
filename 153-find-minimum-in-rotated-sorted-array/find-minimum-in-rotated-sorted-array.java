class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int min=(int)1e9;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                min=Math.min(nums[j],min);
            }
        }
        return min;
    }
}