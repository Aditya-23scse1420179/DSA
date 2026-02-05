class Solution {
    static int[] dr ={-1, 1,0, 0};
    static int[] dc ={0,0,1,-1};
    static int rowL;
    static int colL;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rowL=image.length;
        colL =image[0].length;
        int originalColor =image[sr][sc];
        if (originalColor!=color) {
            dfs(sr,sc,image,originalColor,color);
        }
        return image;
    }
    public void dfs(int sr,int sc,int[][] image,int originalColor,int newColor) {
        if (sr<0||sc<0||sr>=rowL||sc >=colL||image[sr][sc]!= originalColor) return;
        image[sr][sc] =newColor;
        for (int i=0;i< 4;i++) {
            dfs(sr+dr[i],sc+dc[i],image,originalColor,newColor);
        }
    }
}