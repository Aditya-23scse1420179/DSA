class Solution {
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};

    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int[][]in=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int r=i;
                int c=j;
                for(int d=0;d<4;d++){
                    int nr=r+dr[d];
                    int nc=c+dc[d];
                    if(nr>=0&&nr<n&&nc>=0&&nc<m&&matrix[nr][nc]<matrix[r][c]){
                        in[r][c]++;
                    }
                }
            }
        }Queue<int[]>q=new LinkedList<>();
        int[][]dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=1;
                if(in[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }int maxl=0;
        while(!q.isEmpty()){
            int[]curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            maxl=Math.max(maxl,dist[r][c]);
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&matrix[nr][nc]>matrix[r][c]){
                    dist[nr][nc]=Math.max(dist[r][c]+1,dist[nr][nc]);
                    in[nr][nc]--;
                    if(in[nr][nc]==0)q.offer(new int[]{nr,nc});
                }
            }
        }
        return maxl;
    }
}