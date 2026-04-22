class Solution {
    static int dr[]={-1,1,0,0};
    static int dc[]={0,0,-1,1};
    int n;
    int m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        n=image.length;
        m=image[0].length;
        if(image[sr][sc]!=color){
            dfs(sr,sc,image,color,image[sr][sc]);
        }
        return image;
    }public void dfs(int sr,int sc,int[][]image,int color,int ncolor){
        if(sr<0||sr>=n||sc<0||sc>=m||image[sr][sc]!=ncolor)return;
        image[sr][sc]=color;
        for(int i=0;i<4;i++){
            dfs(sr+dr[i],sc+dc[i],image,color,ncolor);
        }
    }
}