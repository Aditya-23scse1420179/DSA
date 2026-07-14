class Solution {
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    int rl,cl;
    int[][]heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights=heights;
        rl=heights.length;
        cl=heights[0].length;
       List<List<Integer>>list=new ArrayList<>();
       boolean[][]p=new boolean[rl][cl];
       boolean[][]a=new boolean[rl][cl];
       for(int i=0;i<rl;i++){
        dfs(i,0,p);
        dfs(i,cl-1,a);
       }
       for(int i=0;i<cl;i++){
        dfs(0,i,p);
        dfs(rl-1,i,a);
       }
       for(int i=0;i<rl;i++){
        for(int j=0;j<cl;j++){
            if(a[i][j]&&p[i][j])list.add(Arrays.asList(i,j));
        }
       }
       return list;
    }public void dfs(int i,int j,boolean[][]visit){
        if(visit[i][j])return ;
        visit[i][j]=true;
        for(int d=0;d<4;d++){
            int r=i+dr[d];
            int c=j+dc[d];
            if(r<0||r>=rl||c<0||c>=cl)continue;
            if(heights[r][c]<heights[i][j])continue;
            dfs(r,c,visit);
        }
    }
}