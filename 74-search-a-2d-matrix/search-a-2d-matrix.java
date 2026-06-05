class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int l=0,r=n-1;
        int row=-1;
        while(l<=r){
            int mid=(l+r)>>1;
            if(matrix[mid][m-1]>target){
                row=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
            if(matrix[mid][m-1]==target)return true;
        }
        if(row==-1)return false;
        int le=0;
        int re=m-1;
        while(le<=re){
            int mid=(le+re)>>1;
            if(matrix[row][mid]<target){
                le=mid+1;
            }else if(matrix[row][mid]>target){
                re=mid-1;
            }
            if(matrix[row][mid]==target)return true;
        }
        return false;
    }
}