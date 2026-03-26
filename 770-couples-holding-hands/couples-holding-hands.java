class Solution {
    int[]parent;
    int []rank;
    public int minSwapsCouples(int[] row) {
        parent=new int[row.length/2];
        rank=new int[row.length/2];
        int n=row.length;
        for(int i=0;i<n/2;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i+=2){
            int c1=row[i]/2;
            int c2=row[i+1]/2;
            unionrank(c1,c2);
        }
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n/2;i++){
            set.add(find(i));
        }
        return n/2-set.size();
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public boolean unionrank(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py)return false;
        if(rank[px]>rank[py]){
            parent[py]=px;
        }else if(rank[px]<rank[py]){
            parent[px]=py;
        }else{
            parent[px]=py;
            rank[py]++;
        }
        return true;
    }
}