class Solution {
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    
    public int minCost(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][][]dp=new int[n][m][5][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int d=0;d<5;d++){
                    Arrays.fill(dp[i][j][d],Integer.MAX_VALUE);
                }
            }
        }
        PriorityQueue<int[]>q=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        dp[0][0][4][0]=grid[0][0];
        q.offer(new int[]{grid[0][0], 0, 0, 4, 0});
        
        while(!q.isEmpty()){
            int[]curr=q.poll();
            int cost=curr[0];
            int r=curr[1];
            int c=curr[2];
            int dir=curr[3];
            int turn=curr[4];
            if(r==n-1&&c==m-1)return cost;
            
            if(cost>dp[r][c][dir][turn])continue;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m){
                    int nt=turn;;
                    if(dir!=4&&dir!=i)nt++;
                    if(nt<=k){
                        int nco=cost+grid[nr][nc];
                        if(nco<dp[nr][nc][i][nt]){
                            dp[nr][nc][i][nt]=nco;
                            q.offer(new int[]{nco,nr,nc,i,nt});
                        }
                    }
                }
            }
        }
        return -1;
    }
}