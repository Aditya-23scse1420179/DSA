class NumMatrix {
    int n,m;
    int[][]mat;
    public NumMatrix(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        mat=new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                mat[i][j] = matrix[i - 1][j - 1]+ mat[i-1][j]+ mat[i][j-1]-mat[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        int ans=0;
        r1++;c1++;r2++;c2++;
        ans=mat[r2][c2]-mat[r1-1][c2]-mat[r2][c1-1]+mat[r1-1][c1-1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */