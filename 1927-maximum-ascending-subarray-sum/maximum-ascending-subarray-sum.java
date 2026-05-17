class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                boolean ascending = true;
                int sum = nums[i];
                for (int k = i + 1; k <= j; k++) {
                    if (nums[k] <= nums[k - 1]) {
                        ascending = false;
                        break;
                    }
                    sum += nums[k];
                }
                if (ascending) {
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }
}
