class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length, ans=0, i =0;
        while(i < len) {
            int j = i;
            while(j < len - 1 && nums[j] == nums[j + 1]) ++j;
            int f = j - i + 1; // Frequency of current number
            int g = len - (j + 1); // Count of numbers strictly greater
            if(g >= k) ans += f;
            i = j + 1;
        }
        return ans;
    }
}