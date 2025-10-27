class Solution {
    Set<Integer> zeroRows = new HashSet<>();
    Set<Integer> zeroCols = new HashSet<>();
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        scan(matrix, 0, 0, m, n);
        apply(matrix, 0, 0, m, n);
    }    private void scan(int[][] matrix,int i,int j,int m,int n) {
        if (i ==m) return; 
        if (j== n){ 
            scan(matrix, i + 1, 0, m, n); 
            return;
        }
        if(matrix[i][j] ==0){
            zeroRows.add(i);
            zeroCols.add(j);
        }
        scan(matrix, i, j+ 1, m,n); 
    }
    private void apply(int[][] matrix,int i,int j,int m,int n) {
        if (i ==m) return; 
        if (j ==n){
            apply(matrix, i + 1, 0, m, n); 
            return;
        }
        if(zeroRows.contains(i) ||zeroCols.contains(j)){
            matrix[i][j] = 0;
        }
        apply(matrix, i,j +1, m,n);
    }
}
