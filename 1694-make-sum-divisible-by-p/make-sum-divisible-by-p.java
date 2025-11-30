class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }
        int requiredRemainder = (int) (totalSum % p);
        
        if (requiredRemainder == 0) {
            return 0; 
        }
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); 
        
        int currentPrefixMod = 0;
        int minLength = n; 

        for (int i = 0; i < n; i++){
            currentPrefixMod = (currentPrefixMod + nums[i]) % p;
            int targetRemainder = (currentPrefixMod - requiredRemainder + p) % p;
            if (remainderMap.containsKey(targetRemainder)){
                int prevIndex = remainderMap.get(targetRemainder);
                minLength = Math.min(minLength, i - prevIndex);
            }
            remainderMap.put(currentPrefixMod, i);
        }
        return (minLength == n) ? -1 : minLength;
    }
}