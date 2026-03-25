class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int[][] cost_capacity = new int[n][2];

        for (int i = 0; i < n; i++) {
            cost_capacity[i][0] = costs[i];
            cost_capacity[i][1] = capacity[i];
        }

        Arrays.sort(cost_capacity, (a, b) -> a[0] - b[0]);

        int[] bestCapacity = new int[n];
        bestCapacity[0] = cost_capacity[0][1];
        for (int i = 1; i < n; i++) {
            bestCapacity[i] = Math.max(bestCapacity[i - 1], cost_capacity[i][1]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (cost_capacity[i][0] < budget) {
                ans = Math.max(ans, cost_capacity[i][1]);
            }
        }

        for (int i = 1; i < n; i++) {
            int remaining = budget - cost_capacity[i][0] - 1;
            if (remaining <= 0) continue;

            int idx = upperBound(cost_capacity, remaining, i - 1);
            if (idx >= 0) {
                ans = Math.max(ans, cost_capacity[i][1] + bestCapacity[idx]);
            }
        }
        return ans;
    }

    private int upperBound(int[][] arr, int val, int high) {
        int low = 0, res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid][0] <= val) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}