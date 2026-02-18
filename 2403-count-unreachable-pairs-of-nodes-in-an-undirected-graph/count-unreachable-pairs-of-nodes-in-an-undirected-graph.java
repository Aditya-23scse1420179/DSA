class Solution {
    int[]parent;
    int[]size;
    public long countPairs(int n, int[][] edges) {
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int[]a:edges){
            unionsize(a[0],a[1]);
        }List<Integer>comp = new ArrayList<>();
        for (int i=0;i< n;i++) {
            if (find(i)==i){ 
                comp.add(size[i]);
            }
        }
        long total= 0;
        long sum =0;
        for (int s:comp){
            total+=(long)s*sum;
            sum+=s;
        }
        return total;
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public boolean unionsize(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py)return false;
        if(size[px]>size[py]){
            parent[py]=px;
            size[px]+=size[py];
        }else if(size[py]>size[px]){
            parent[px]=py;
            size[py]+=size[px];
        }else {
            parent[px]=py;
            size[py]+=size[px];
        }
        return true;
    }
}