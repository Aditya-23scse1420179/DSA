class Solution {
    public void gameOfLife(int[][] b) {
        int arr[][]=new int[b.length][b[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                int count=0;
                if(i>0 && b[i-1][j]==1) count++;
                if(i<b.length-1 && b[i+1][j]==1) count++;
                if(j>0 && b[i][j-1]==1) count++;
                if(j<b[0].length-1 && b[i][j+1]==1) count++;
                if(i>0 && j>0 && b[i-1][j-1]==1) count++;
                if(i>0 && j<b[0].length-1 && b[i-1][j+1]==1) count++;
                if(i<b.length-1 && j>0 && b[i+1][j-1]==1) count++;
                if(i<b.length-1 && j<b[0].length-1 && b[i+1][j+1]==1) count++;
                
                if(b[i][j]==1 && count==2 || count==3) arr[i][j]=1;
                else if(b[i][j]==0 && count==3) arr[i][j]=1;
                else arr[i][j]=0;
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                b[i][j]=arr[i][j];
            }
        }
    }
}