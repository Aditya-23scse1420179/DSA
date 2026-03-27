class Solution {
    public int partitionDisjoint(int[] nums) {
        int ans = 0, lmax = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);   // hamesha update karo
            if (nums[i] < lmax) {
                ans = i;        // partition index update
                lmax = max;     // left max ko extend karo
            }
        }
        return ans + 1;
    }
}
