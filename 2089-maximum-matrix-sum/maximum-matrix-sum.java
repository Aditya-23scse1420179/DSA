class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        long curr=0;
        int neg=0;
        int mins=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val=matrix[i][j];
                curr+=Math.abs(val);
                if(val<0)neg++;
                mins=Math.min(mins,Math.abs(val));
            }
        }
        if(neg%2==0)return curr;
        else return curr-2*mins;
    }
}