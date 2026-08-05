class Solution {
    List<List<Integer>>adj;
    Set<Integer>set;
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []a:invocations){
            int u=a[0];
            int v=a[1];
            adj.get(u).add(v);
        }
        set=new HashSet<>();
        dfs(k);
        for(int i=0;i<n;i++){
            if(!set.contains(i)){
                for(int a:adj.get(i)){
                    if(set.contains(a)){
                        List<Integer>list=new ArrayList<>();
                        for(int j=0;j<n;j++)list.add(j);
                        return list;
                    }
                }
            }
        }
        List<Integer>res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!set.contains(i))res.add(i);
        }
        return res;
    }public void dfs(int u){
        if(set.contains(u))return ;
        set.add(u);
        for(int a:adj.get(u))dfs(a);
    }
}