class Solution {
    int n,m;
    int [][]matr,matc;
    static int[]dr={0,0,-1,-1,1,1};
    static int[]dc={-1,1,-1,1,-1,1};
    public int maxStudents(char[][] seats) {
        n=seats.length;
        m=seats[0].length;
        matr=new int[n][m];
        matc=new int[n][m];
        int count=0;
        int total=0;
        for(int i=0;i<n;i++){
            Arrays.fill(matr[i],-1);
            Arrays.fill(matc[i],-1);
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
                if(matr[nr][nc]==-1||dfs(matr[nr][nc],matc[nr][nc],seats,visit)){
                    matr[nr][nc]=r;
                    matc[nr][nc]=c;//idx store kar lo 
                    return true;
                }
            }
        }
        return false;
    }
}