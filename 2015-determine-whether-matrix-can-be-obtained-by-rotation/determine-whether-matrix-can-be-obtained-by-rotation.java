class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        for(int i=0;i<4;i++){// 4 bebcause all 4 degree 0,90,180,270
            if(same(mat,target,n))return true;
            rotate(mat,n);
        }
        return false;
    }public boolean same(int[][]mat,int[][]target,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=target[i][j])return false;
            }
        }
        return true;
    }public void rotate(int[][] mat, int n) {
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
}