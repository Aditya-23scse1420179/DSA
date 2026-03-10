class TreeAncestor {
    static int N;
    static int log=19;
    static int [][]up;
    public TreeAncestor(int n, int[] parent) {
        N=n;
        up=new int[N][log];
        for(int []a:up){
            Arrays.fill(a,-1);
        }
        for(int i=0;i<parent.length;i++){
            up[i][0]=parent[i];
        }
        for(int i=1;i<log;i++){
            for(int node=0;node<N;node++){
                if(up[node][i-1]!=-1){
                    up[node][i]=up[up[node][i-1]][i-1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i=log-1;i>=0;i--){
            if((k&(1<<i))!=-0){
                node=up[node][i];
                if(node==-1)return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */