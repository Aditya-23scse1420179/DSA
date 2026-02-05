class Solution {
    static class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public int numEnclaves(int[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        boolean[][] visit = new boolean[rl][cl];
        Queue<Pair> q = new LinkedList<>();
        // Add boundary land cells
        for (int i = 0; i < rl; i++) {
            if (grid[i][0] == 1) {
                q.add(new Pair(i, 0));
                visit[i][0] = true;
            }
            if (grid[i][cl - 1] == 1) {
                q.add(new Pair(i, cl - 1));
                visit[i][cl - 1] = true;
            }
        }
        for (int j = 0; j < cl; j++) {
            if (grid[0][j] == 1) {
                q.add(new Pair(0, j));
                visit[0][j] = true;
            }
            if (grid[rl - 1][j] == 1){
                q.add(new Pair(rl - 1, j));
                visit[rl - 1][j] = true;
            }
        }
        // BFS to mark boundary-connected land
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];
                if (nr >= 0 && nc >= 0 && nr < rl && nc < cl &&
                    grid[nr][nc] == 1 && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
        // Count enclaves (land not visited)
        int count = 0;
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
