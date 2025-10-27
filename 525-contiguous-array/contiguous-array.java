class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0,maxLen = 0;
        for (int i= 0;i <n;i++){
            sum += nums[i] == 1 ?1:-1;
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen,i- map.get(sum));
            } else {
                map.put(sum,i);
            }
        }
        return maxLen;
    }
}
