class Solution {
    public boolean searchMatrix(int[][] matrix, int target) { 
            int low=0;int high=matrix.length-1;
            int row=-1;
            while(low<=high){
                int mid=low + (high-low)/2;
                if(matrix[mid][matrix[0].length-1]==target)return true;
                else if(matrix[mid][matrix[0].length-1]>target){
                    row=mid;
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }  
            if(row==-1)return false;
 
                int left=0;
                int right=matrix[0].length-1;
                while(left<=right){
                    int mid = left + (right - left) / 2;
                    if(matrix[row][mid]==target)return true;
                    else if(matrix[row][mid]<target){
                        left = mid+1;
                    }
                    else if(matrix[row][mid]>target){
                        right=mid-1;
                    }
                }
                return false;
            
            
       
        
    }
}