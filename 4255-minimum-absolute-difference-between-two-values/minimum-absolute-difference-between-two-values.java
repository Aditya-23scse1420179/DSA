class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int minDiff = Integer.MAX_VALUE;
        int last1 = -1; // Track the most recent index of 1
        int last2 = -1; // Track the most recent index of 2
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                last1 = i;
                if (last2 != -1) {
                    minDiff = Math.min(minDiff, i - last2);
                }
            } else if (nums[i] == 2) {
                last2 = i;
                if (last1 != -1) {
                    minDiff = Math.min(minDiff, i - last1);
                }
            }
        }
        return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
    }
}