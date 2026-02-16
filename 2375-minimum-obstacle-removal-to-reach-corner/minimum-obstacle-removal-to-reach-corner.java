class Solution { 
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    public class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist =new int[n][m];
        for (int[] a :dist) {
            Arrays.fill(a,(int)1e9);
        }
        dist[0][0] = 0;
        Queue<pair>q= new LinkedList<>();
        q.offer(new pair(0, 0));
        while (!q.isEmpty()) {
            pair curr=q.remove();
            int r =curr.row;
            int c=curr.col;
            for (int i =0;i<4;i++) {
                int nr= r+dr[i];
                int nc=c+dc[i];
                if (nr<0||nc <0||nr>=n||nc>=m) continue;
                int newDist=dist[r][c]+grid[nr][nc];
                if (newDist<dist[nr][nc]){
                    dist[nr][nc]=newDist;
                    q.offer(new pair(nr, nc));
                }
            }
        }
        return dist[n-1][m-1];
    }
}
