class Solution {
    int[]parent;
    int []rank;
    int component;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //email ko unique id deni hai 
        HashMap<String,Integer>emailToId=new HashMap<>();
        // email ko uske account ke sath accosiat ekaro 
        HashMap<String,String>emailToName=new HashMap<>();
        int id=0;
        for(List<String>acc:accounts){
            String name=acc.get(0);
            for(int i=1;i<acc.size();i++){
                String email=acc.get(i);
                if(!emailToId.containsKey(email)){
                    emailToId.put(email,id++);
                }
                emailToName.put(email,name);
            }
        }
        component=id;
        parent=new int[id];
        rank=new int[id];
        for(int i=0;i<id;i++){
            parent[i]=i;
        }
        // merge same account ke mail
        for(List<String>acc:accounts){
            if(acc.size()<=2)continue;
            int firstAccountId=emailToId.get(acc.get(1));
            for(int i=2;i<acc.size();i++){
                unionrank(firstAccountId,emailToId.get(acc.get(i)));
            }
        }
        HashMap<Integer,List<String>>grouptoid=new HashMap<>();
        for(String email:emailToId.keySet()){
            int EmailId=emailToId.get(email);
            int root=find(EmailId);
            if(!grouptoid.containsKey(root)){
                grouptoid.put(root,new ArrayList<>());
            }grouptoid.get(root).add(email);
        }
        List<List<String>>result=new ArrayList<>();
        for(Integer node:grouptoid.keySet()){
            List<String>merge=grouptoid.get(node);
            Collections.sort(merge);
            merge.add(0,emailToName.get(merge.get(0)));
            result.add(merge);
        }
        return result;
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
        }else {
            parent[p_x]=p_y;
            rank[p_y]++;
        }
        return true;
    }
}