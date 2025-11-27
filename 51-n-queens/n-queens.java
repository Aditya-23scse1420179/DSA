class Solution {
    public List<List<String>> solveNQueens(int n) {
        char [][]board = new char[n][n];
        List<List<String>>ans = new ArrayList<>();
        for( int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        nqueen(board,0,ans);
        return ans ;
    }
    public void nqueen(char[][]board,int row,List<List<String>>ans ){
        int n = board.length;
        if(row==n){
            ans.add(convert(board));
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                nqueen(board,row+1,ans);
                board[row][col]='.';
            }
        }
    }
    public boolean isSafe(char[][]board,int row,int col){
        int n = board.length;
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q')return false;
        }
        int i=row,j=col;
        while(i>=0&&j>=0){
            if(board[i--][j--]=='Q')return false;
        }
        i=row;
        j=col;
        while(i>=0&&j<n){
            if(board[i--][j++]=='Q')return false;
        }
        return true;
    }
    public List<String> convert(char[][]board){
        List<String>list=new ArrayList<>();
        for(char[]row:board){
            list.add(new String(row));
        }
        return list;
    }
}