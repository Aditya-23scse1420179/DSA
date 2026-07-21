class Solution {
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    class pair{
        int ro,co;
        public pair(int ro,int co){
            this.ro=ro;
            this.co=co;
        }
    }
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)q.offer(new pair(i,j));
            }
        }int count=-1;
        if(q.isEmpty()||q.size()==n*n)return -1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                pair curr=q.poll();
                int r=curr.ro;
                int c=curr.co;
                for(int i=0;i<4;i++){
                    int nr=r+dr[i];
                    int nc=c+dc[i];
                    if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==0){
                        grid[nr][nc]=1;
                        q.offer(new pair(nr,nc));
                    }
                }
            }
            count++;
        }
        return count;
    }
    
}