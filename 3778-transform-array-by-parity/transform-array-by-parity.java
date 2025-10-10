class Solution {
    public int[] transformArray(int[] nums) {
        int[]ans = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            ans[i] = (nums[i]%2==0)?0:1;
        }
        Arrays.sort(ans); 
        return ans;
    }
}
