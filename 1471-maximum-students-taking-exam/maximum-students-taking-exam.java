class Solution {
    int n,m;
    int [][]mat;
    static int[]dr={0,0,-1,-1,1,1};
    static int[]dc={-1,1,-1,1,-1,1};
    public int maxStudents(char[][] seats) {
        n=seats.length;
        m=seats[0].length;
        mat=new int[n][m];
        int count=0;
        int total=0;
        for(int[] a:mat){
            Arrays.fill(a,-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(seats[i][j]=='#')continue;
                if(j%2==0){
                    boolean[][]visit=new boolean[n][m];
                    if(dfs(i,j,seats,visit))count++;
                }
                total++;
            }
        }
        return total-count;
    }public boolean dfs(int r,int c,char[][]seats,boolean[][]visit){
        for(int i=0;i<6;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            // int u=nr*m+nc;
            if(nr>=0&&nc>=0&&nr<n&&nc<m&&!visit[nr][nc]&&seats[nr][nc]!='#'){
                visit[nr][nc]=true;
                if(mat[nr][nc]==-1||dfs(mat[nr][nc]/m,mat[nr][nc]%m,seats,visit)){
                    mat[nr][nc]=r*m+c;
                    return true;
                }
            }
        }
        return false;
    }
}