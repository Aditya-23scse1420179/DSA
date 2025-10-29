class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int k = 0;k < 4;k++) {
            if (areSame(mat, target, n)) {
                return true;
            }
            rotate90(mat, n);
        }
        return false;
    }
    private void rotate90(int[][] mat, int n) {
        for(int i =0;i< n/2;i++){
            int[]temp =mat[i];
            mat[i] =mat[n -1 -i];
            mat[n-1-i] =temp;
        }
        for(int i= 0;i <n;i++){
            for(int j =i+1;j< n;j++){
                int temp =mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    private boolean areSame(int[][] a, int[][] b, int n) {
        for(int i= 0; i <n;i++){
            for (int j = 0; j <n;j++){
                if (a[i][j]!=b[i][j]) return false;
            }
        }
        return true;
    }
}
