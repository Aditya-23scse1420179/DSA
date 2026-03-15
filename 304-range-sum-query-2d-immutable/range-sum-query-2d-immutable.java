class NumMatrix {
    int n,m;
    int[][]mat;
    public NumMatrix(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        mat=new int[n][m];
        mat[0][0]=matrix[0][0];
        for(int i=1;i<n;i++){
            mat[i][0]=mat[i-1][0]+matrix[i][0];
        }for(int j=1;j<m;j++){
            mat[0][j]=mat[0][j-1]+matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                mat[i][j]=matrix[i][j]+mat[i-1][j]+mat[i][j-1]-mat[i-1][j-1];
            }
        }

    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        int ans=0;
        ans+=mat[r2][c2];
        if(r1>0){
            ans-=mat[r1-1][c2];
        }
        if(c1>0){
            ans-=mat[r2][c1-1];
        }if(r1>0&&c1>0){
            ans+=mat[r1-1][c1-1];
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */