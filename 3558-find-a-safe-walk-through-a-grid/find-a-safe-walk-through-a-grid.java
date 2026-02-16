class Solution {
    static int []dr={-1,1,0,0};
    static int []dc={0,0,-1,1};
    public class pair{
        int row;
        int col;
        int dist;
        public pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();
        int[][]distance=new int[n][m];
        for(int []a:distance){
            Arrays.fill(a,-1);
        }
        int starth=health-grid.get(0).get(0);
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)->Integer.compare(b.dist,a.dist));
        q.offer(new pair(0,0,starth));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            int w=curr.dist;
            for (int i=0;i<4;i++) {
                int nr=r+dr[i];
                int nc=c+dc[i];
                if (nr>=0&&nr<n&&nc>=0&& nc<m) {
                    int newHealth=w-grid.get(nr).get(nc);
                    if (newHealth >=1&&newHealth>distance[nr][nc]) {
                        distance[nr][nc]=newHealth;
                        q.offer(new pair(nr,nc,newHealth));
                    }
                }
            }
        }
        return distance[n-1][m-1]>=1;
    }
}