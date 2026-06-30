class Solution {
    int[]parent=new int[26];
    // int[] rank=new int[26];
    public boolean equationsPossible(String[] equations) {
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        for(String eq:equations){
            if(eq.charAt(1)=='='){
                int u=eq.charAt(0)-'a';
                int v=eq.charAt(3)-'a';
               parent[find(u)]=parent[find(v)];
            }
        }
        for(String eq:equations){
            if(eq.charAt(1)=='!'){
                int u=eq.charAt(0)-'a';
                int v=eq.charAt(3)-'a';
                if(find(u)==find(v))return false;
            }
        }
        return true;
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }
    // public boolean union(int x,int y){
    //     int px=find(x);
    //     int py=find(y);
    //     if(px==py)return true;
    //     if(rank[px]>rank[py]){
    //         parent[py]=px;
    //     }else if(rank[py]>rank[px]){
    //         parent[px]=py;
    //     }else{
    //         parent[px]=py;
    //         rank[py]++;
    //     }
    //     return false;
    // }
}