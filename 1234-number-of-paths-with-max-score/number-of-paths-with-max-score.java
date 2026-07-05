class Solution {
    int[]dr={-1,0,-1};
    int[]dc={0,-1,-1};
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();

        int[][]dist=new int[n][n];
        for(int[]a:dist){
            Arrays.fill(a,-1);
        }
        int[][]count=new int[n][n];
        dist[n-1][n-1]=0;
        count[n-1][n-1]=1;
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(board.get(i).charAt(j)=='X')continue;
                if (dist[i][j] == -1) continue;
                for(int d=0;d<3;d++){
                    int r=i+dr[d];
                    int c=j+dc[d];
                    if(r<0||r>=n||c<0||c>=n)continue;
                    char ch=board.get(r).charAt(c);
                    if(ch=='X') continue;

                    int val=ch=='E'||ch=='S'?0:ch-'0';
                    int score=val+dist[i][j];
                    if(score>dist[r][c]){
                        dist[r][c]=score;
                        count[r][c]=count[i][j];

                    }else if(score==dist[r][c]){
                        count[r][c]=(count[r][c]+count[i][j])%1000000007;;
                    }
                }
            }
        }
        if(dist[0][0]==-1)return new int[]{0,0};
        return new int[]{dist[0][0],count[0][0]};
    }
}