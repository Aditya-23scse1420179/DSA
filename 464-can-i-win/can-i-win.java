class Solution {
    HashMap<Integer,Boolean>map=new HashMap<>();
    public boolean canIWin(int m, int d) {
        int sum=0;
        for(int i=1;i<=m;i++)sum+=i;
        if(sum<d)return false;
        return dfs(0,m,d);
    }public boolean dfs(int mask,int m,int d){
        if(map.containsKey(mask)){
            return map.get(mask);
        }
        for(int i=1;i<=m;i++){
            if((mask & (1<<i))==0){
                if(i>=d){
                    map.put(mask,true);
                    return true;
                }
                if(!dfs(mask|(1<<i),m,d-i)){
                    map.put(mask,true);
                    return true;
                }
            }
        }
        map.put(mask,false);
        return false;
    }
}