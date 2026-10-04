class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int rl, cl;
    boolean[][] visit;
    class pair{
        int row,col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        rl = grid.length;
        cl = grid[0].length;
        visit = new boolean[rl][cl];
        int maxa = 0;

        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    int area = bfs(i, j, grid);
                    maxa = Math.max(maxa, area);
                }
            }
        }
        return maxa;
    }
    public int bfs(int startRow, int startCol, int[][] grid) {
        Queue<pair> queue = new LinkedList<>();
        queue.offer(new pair(startRow,startCol));
        visit[startRow][startCol] = true;
        int area = 0;
        while (!queue.isEmpty()) {
            pair curr = queue.poll();
            int r = curr.row;
            int c = curr.col;
            area++;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < rl && nc >= 0 && nc < cl && grid[nr][nc] == 1 && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    queue.offer(new pair(nr, nc));
                }
            }
        }
        return area;
    }
}