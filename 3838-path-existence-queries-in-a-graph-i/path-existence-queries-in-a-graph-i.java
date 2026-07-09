class Solution {
    int[]parent;
    int[]rank;
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[]arr=new boolean[queries.length];
        rank=new int[n+1];
        parent=new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int[][] pairs=new int[n][2];
        for (int i=0;i<n;i++) {
            pairs[i][0]=nums[i];
            pairs[i][1]=i;
        }
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
        for (int i=1;i<n;i++){
            if(pairs[i][0]-pairs[i-1][0]<=maxDiff){
                parent[pairs[i][1]]=parent[pairs[i-1][1]];
            }
        }
        for(int i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            arr[i]=find(u)==find(v);
        }
        return arr;
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }
    // public boolean union(int x,int y){
    //     int px=find(x);
    //     int py=find(y);
    //     if(px==py)return false;
    //     if(rank[px]>rank[py]){
    //         parent[py]=px;
    //     }else if(rank[py]>rank[px]){
    //         parent[px]=py;
    //     }else{
    //         parent[px]=py;
    //         rank[py]++;
    //     }
    //     return true;
    // }
}