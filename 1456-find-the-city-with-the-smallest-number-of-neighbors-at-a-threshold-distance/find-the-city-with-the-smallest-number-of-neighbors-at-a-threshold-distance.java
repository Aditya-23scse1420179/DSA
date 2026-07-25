class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int m=edges[0].length;
        int[][]dist=new int[n][n];
        for(int[]a:dist){
            Arrays.fill(a,(int)1e9);
        }
        for(int i=0;i<n;i++){
            dist[i][i]=0;
        }
        for(int[]a:edges){
            int u=a[0];
            int v=a[1];
            int w=a[2];
            dist[u][v]=w;
            dist[v][u]=w;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        int res=-1,rep=(int)1e9;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j&&dist[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=rep){
                rep=count;
                res=i;
            }
        }
        return res;

    }
}