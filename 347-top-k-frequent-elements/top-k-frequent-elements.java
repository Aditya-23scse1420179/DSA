class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            buckets[i] = new ArrayList<>();
        }for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int number = entry.getKey();
            int count  = entry.getValue();
            buckets[count].add(number);
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = n; i >= 0 && resultList.size() < k; i--) {
            for (int number : buckets[i]) {
                resultList.add(number);
                if (resultList.size() == k) break;
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
