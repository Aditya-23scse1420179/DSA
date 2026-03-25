class Solution {
    static int []dr={0,0,-1,-1,1,1};
    static int[]dc={-1,1,-1,1,-1,1};
    static int n;
    static int m;
    static int[][]matA;
    static int[][]matB;
    static boolean[][]visit;
    public int maxStudents(char[][] seats) {
        n=seats.length;
        m=seats[0].length;
        int count=0;
        int total=0;
        matA=new int[n][m];
        matB=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(matA[i],-1);
            Arrays.fill(matB[i],-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(seats[i][j]=='#')continue;
                if(j%2==0){
                    visit=new boolean[n][m];
                    if(dfs(i,j,seats))count++;
                }
                total++;
            }
        }
        return total-count;
    }public boolean dfs(int r,int c,char[][]seats){
        for(int i=0;i<6;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&seats[nr][nc]=='.'&&!visit[nr][nc]){
                 visit[nr][nc]=true;
                if(matA[nr][nc]==-1||dfs(matA[nr][nc],matB[nr][nc],seats)){
                    matA[nr][nc]=r;
                    matB[nr][nc]=c;
                    return true;
                }
            }
        }
        return false;
    }
}