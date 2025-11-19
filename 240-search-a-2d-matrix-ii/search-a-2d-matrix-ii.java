class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            int k=0;int j=matrix[i].length-1;
            while(k<=j){
                int mid=k+(j-k)/2;
                if(matrix[i][mid]==target)return true;
                else if(matrix[i][mid]>target){
                    j=mid-1;
                }else{
                    k=mid+1;
                }
            }
        //     k=0;j=matrix.length-1;
        //     if(i<matrix[0].length){
        //         while(k<=j){
        //          int mid=k+(j-k)/2;
        //          if(matrix[mid][i]==target)return true;
        //          else if(matrix[mid][i]>target){
        //             j=mid-1;
        //          }else{
        //             k=mid+1;
        //          }
        //     }
        //     }
            
        }
        return false;
    }
}