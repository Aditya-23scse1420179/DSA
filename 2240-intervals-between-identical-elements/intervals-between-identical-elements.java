import java.util.*;

class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> indices : map.values()) {
            int m = indices.size();
            long[] prefix = new long[m+1];
            for (int i = 0; i < m; i++) {
                prefix[i+1] = prefix[i] + indices.get(i);
            }
            for (int i = 0; i < m; i++) {
                int idx = indices.get(i);
                long left = (long)indices.get(i) * i - prefix[i];
                long right = (prefix[m] - prefix[i+1]) - (long)(m-i-1) * indices.get(i);
                ans[idx] = left + right;
            }
        }
        return ans;
    }
}
