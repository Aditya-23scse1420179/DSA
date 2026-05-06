class Solution {
    int n;
    int m;
    public char[][] rotateTheBox(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        char[][]ans=new char[m][n];
        for(char[]a:ans){
            Arrays.fill(a,'.');
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[j][n-1-i]=grid[i][j];
            }
        }
        for(int j=0;j<n;j++){
            int d=m-1;
            for(int i=m-1;i>=0;i--){
                if(ans[i][j]=='*'){
                    d=i-1;
                }
                else if(ans[i][j]=='#'){
                    ans[i][j]='.';
                    ans[d][j]='#';
                    d--;
                }

            }
        }
        return ans;
         
    }
}