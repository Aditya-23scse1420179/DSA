class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static class pair{
        int r,c;
        public pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new pair(i,j));
                }else if(grid[i][j]==1)fresh++;
            }
        }int level=0;
        while(!q.isEmpty()){
            boolean found=false;
            int size=q.size();
            while(size-->0){
                pair curr=q.poll();
                int row=curr.r;
                int col=curr.c;
                for(int i=0;i<4;i++){
                    int nr=row+dr[i];
                    int nc=col+dc[i];
                    if(nr<0||nr>=n||nc<0||nc>=m)continue;
                    if(grid[nr][nc]==1){
                        fresh--;
                        grid[nr][nc]=2;
                        found=true;
                        q.offer(new pair(nr,nc));
                    }
                }
            }
            if(found)level++;
        }
        return fresh==0?level:-1;

    }
}