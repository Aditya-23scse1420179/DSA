class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n=matrix.length;
        int []ans=new int[n];
        for(int i=0;i<n;i++){
            int d=0;
            for(int j=0;j<n;j++){
                d+=matrix[i][j];
            }
            ans[i]=d;
        }
        return ans;
    }
}