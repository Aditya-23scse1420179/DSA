class Solution {
    public int[][] cyclicShift(int n, int[][] g, int[] rowShift, int[] colShift) {
        int[][]grid=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int nc=(j-rowShift[i]+n)%n;
                grid[i][nc]=g[i][j];
            }
        }
        int[][]res=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int nr=(i-colShift[j]+n)%n;
                res[nr][j]=grid[i][j];
            }
        }
        return res;
    }
}