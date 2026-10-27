class Solution {
    public String[] createGrid(int m, int n) {
        char[][]grid=new char[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(grid[i],'#');
        }
        int r=0,c=0;
        grid[r][c]='.';
        while(r<m-1||c<n-1){
            if(c<n-1&&(r==m-1||c<n-2)){
                c++;
            }else{
                r++;
            }
            grid[r][c]='.';
        }
        String[]list=new String[m];
        for(int i=0;i<m;i++){
            list[i]=new String(grid[i]);
        }
        return list;
    }
}