class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length,m=board[0].length;
        int[][]b=new int[n][m];
        for(int i=0;i<n;i++){
            // int count=0;
            for(int j=0;j<m;j++){
                int count=0;
                if(i>0&&j>0&&board[i-1][j-1]==1)count++;//uL
                if(i>0&&board[i-1][j]==1)count++;//u
                if(i>0&&j<m-1&&board[i-1][j+1]==1)count++;//ur
                if(j>0&&board[i][j-1]==1)count++;//l
                if(j<m-1&&board[i][j+1]==1)count++;//r
                if(i<n-1&&j>0&&board[i+1][j-1]==1)count++;//ll
                if(i<n-1&&board[i+1][j]==1)count++;//down
                if(i<n-1&&j<m-1&&board[i+1][j+1]==1)count++;
                
                if(board[i][j]==1&&count==2||count==3){
                    b[i][j]=1;
                }
                else if(board[i][j]==0&&count==3)b[i][j]=1;
                else b[i][j]=0;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j]=b[i][j];
            }
        }
    }
}