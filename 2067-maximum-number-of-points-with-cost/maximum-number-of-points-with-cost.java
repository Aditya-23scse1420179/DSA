class Solution {
    int n,m;
    public long maxPoints(int[][] points) {
        n=points.length;
        m=points[0].length;
        long[]prev=new long[m];
        for(int i=0;i<m;i++){
            prev[i]=points[0][i];
        }
        for(int i=1;i<n;i++){
            long[]l=new long[m];
            long[]r=new long[m];
            long[]c=new long[m];
            r[m-1]=prev[m-1];
            l[0]=prev[0];
            for(int j=1;j<m;j++){
                l[j]=Math.max(prev[j],l[j-1]-1);
            }
            for(int j=m-2;j>=0;j--){
                r[j]=Math.max(prev[j],r[j+1]-1);
            }
            for(int j=0;j<m;j++){
                c[j]=points[i][j]+Math.max(l[j],r[j]);
            }
            prev=c;
        }long ans=0;
        for(int i=0;i<m;i++){
            ans=Math.max(ans,prev[i]);
        }
        return ans;
    }
}