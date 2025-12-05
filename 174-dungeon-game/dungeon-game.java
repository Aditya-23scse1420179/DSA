class Solution {
    int m, n;
    public int calculateMinimumHP(int[][] d) {
        m = d.length;
        n = d[0].length;
        int left = 1;
        int right = 4 * (int)1e7;   // upper bound
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // memo: stores the best (max) health when entering a cell
            int[][] seen = new int[m][n];
            for (int[] row : seen) Arrays.fill(row, -1);
            if (canSurvive(0, 0, mid, d, seen)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    private boolean canSurvive(int i, int j, int health, int[][] d, int[][] seen) {
        // Out of bounds
        if (i >= m || j >= n) return false;
        health += d[i][j];
        if (health <= 0) return false;
        // If we reach this cell with <= health seen before → pruning
        if (seen[i][j] >= health) return false;
        seen[i][j] = health;
        // Reached destination
        if (i == m - 1 && j == n - 1) return true;
        // Try right or down
        return canSurvive(i, j + 1, health, d, seen) 
            || canSurvive(i + 1, j, health, d, seen);
    }
}