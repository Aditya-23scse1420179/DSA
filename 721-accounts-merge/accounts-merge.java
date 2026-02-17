class Solution {
    int []parent;
    int[]rank;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent=new int[accounts.size()];
        rank=new int[accounts.size()];
        for(int i=0;i<accounts.size();i++){
            parent[i]=i;
        }
        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
                if(!map.containsKey(email)){
                    map.put(email,i);
                }else{
                    unionrank(i,map.get(email));
                }
            }
        }
        HashMap<Integer,TreeSet<String>>set=new HashMap<>();
        for(String s:map.keySet()){
            int root=find(map.get(s));
            set.putIfAbsent(root,new TreeSet<>());
            set.get(root).add(s);
        }
        List<List<String>>list=new ArrayList<>();
        for(int root:set.keySet()){
            List<String>temp=new ArrayList<>();
            temp.add(accounts.get(root).get(0));
            temp.addAll(set.get(root));
            list.add(temp);
        }
        return list;
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public boolean unionrank(int x,int y){
        int p_x=find(x);
        int p_y=find(y);
        if(p_x==p_y)return false;
        if(rank[p_x]>rank[p_y]){
            parent[p_y]=p_x;
        }else if(rank[p_y]>rank[p_x]){
            parent[p_x]=p_y;
        }else{
            parent[p_x]=p_y;
            rank[p_y]++;
        }
        return true;
    }
}