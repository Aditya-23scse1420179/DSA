class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
         int i=x,j=x+k-1;
        while(i<j){
            for(int l=y;l<k+y;l++){
                int temp=grid[i][l];
                grid[i][l]=grid[j][l];
                grid[j][l]=temp;
            }
            i++;j--;
        }
        return grid;
    }
}