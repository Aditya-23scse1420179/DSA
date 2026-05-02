class Solution {
    public boolean searchMatrix(int[][] mat, int target) { 
        int n=mat.length;
        int m=mat[0].length;
        int low=0, high=n-1;
        int row=-1;
        while(low<=high){
            int mid=low + (high-low)/2;
            if(mat[mid][m-1]>target){
                row=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
            if(mat[mid][m-1]==target)return true;
        }  
        if(row==-1)return false;
        int left=0;
        int right=m-1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(mat[row][mid]<target){
                left = mid+1;
            }
            else if(mat[row][mid]>target){
                right=mid-1;
            }
            if(mat[row][mid]==target)return true;
        }
        return false;
    }
}