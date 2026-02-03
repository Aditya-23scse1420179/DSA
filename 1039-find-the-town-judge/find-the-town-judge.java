class Solution {
    public int findJudge(int n, int[][] trust) {
        int []in=new int [n+1];
        //int[]out=new int [n+1];
        for(int i=0;i<trust.length;i++){
            int u=trust[i][0];
            int v=trust[i][1];
            in[v]++;
           // out[u]++;
            in[u]--;
        }
        for(int i=1;i<=n;i++){
            //if(in[i]==n-1&&out[i]==0)return i;
            if(in[i]==n-1)return i;
        }
        return -1;
    }
}