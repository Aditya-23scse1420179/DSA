class Solution {
    static int dr[] = { -1, 1, 0, 0 };
    static int dc[] = { 0, 0, -1, 1 };
    static int rowL;
    static int colL;

    public int numEnclaves(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;
        boolean [][] visited = new boolean[rowL][colL];
        
        for(int i = 0 ; i < rowL ; i++ ){
            if(grid[i][0] == 1) dfs(i , 0 , visited , grid);
            if(grid[i][colL-1] == 1) dfs(i , colL-1 , visited , grid);
        }
        
        for(int j = 0 ; j < colL;j++){
            if(grid[0][j] == 1) dfs(0 , j , visited , grid);
            if(grid[rowL-1][j] == 1) dfs(rowL-1 , j , visited ,grid);
           
        }int count=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    count++;
                }
            }
        }
        return count;
        
    }

    public void dfs(int r, int c, boolean[][] visited, int[][] grid) {
        if (r < 0 || c < 0 | r >= rowL || c >= colL || grid[r][c] == 0)
            return;
        if (visited[r][c] == true)
            return;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            dfs(r + dr[i], c + dc[i], visited, grid);
        }
    }
}