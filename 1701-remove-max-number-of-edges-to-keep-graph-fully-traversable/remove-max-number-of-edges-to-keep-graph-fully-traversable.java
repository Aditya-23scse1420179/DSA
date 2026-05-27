class Solution {
    class dsu{
        int[]parent;
        int []rank;
        int comp;
        dsu(int n){
            parent=new int[n+1];
            rank=new int[n+1];
            comp=n;
            for(int i=1;i<=n;i++){
                parent[i]=i;
            }
        }
    
        int find(int x){
            if(x==parent[x])return x;
            return parent[x]=find(parent[x]);
        }
        boolean union(int x,int y){
            int px=find(x);
            int py=find(y);
            if(px==py)return false;
            if(rank[px]>rank[py]){
                parent[py]=px;
            }else if(rank[py]>rank[px]){
                parent[px]=py;
            }else{
                parent[px]=py;
                rank[py]++;
            }
            comp--;
            return true;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        dsu alice=new dsu(n);
        dsu bob=new dsu(n);
        int remove=0;
        for(int[]a:edges){
            int type=a[0];
            int u=a[1];
            int v=a[2];
            if(type==3){
                boolean al=alice.union(u,v);
                boolean b=bob.union(u,v);
                if(!al&&!b)remove++;
            }
        }
        for(int a[]:edges){
            int type=a[0];
            int u=a[1];
            int v=a[2];
            if(type==1){
                boolean al=alice.union(u,v);
                if(!al)remove++;
            }
        }
        for(int[]a:edges){
            int type=a[0];
            int u=a[1];
            int v=a[2];
            if(type==2){
                boolean b=bob.union(u,v);
                if(!b)remove++;
            }
        }
        if(alice.comp!=1||bob.comp!=1)return -1;
        else return remove;
    }
}