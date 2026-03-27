class Solution {
    int[]parent;
    int[]size;
    public int largestComponentSize(int[] nums) {
        int n=nums.length;
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int val=nums[i];
            for(int j=2;j*j<=val;j++){
                if(val%j==0){
                    if(map.containsKey(j)){
                        unionsize(i,map.get(j));
                    }else{
                        map.put(j,i);
                    }
                    while(val%j==0){
                        val/=j;
                    }
                }
            }
            if(val>1){
                if(map.containsKey(val)){
                    unionsize(i,map.get(val));
                }else{
                    map.put(val,i);
                }
            }
        }int max=0;
        for(int a:size){
            max=Math.max(max,a);
        }
        return max;
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }
    public boolean unionsize(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py)return false;
        if(size[px]>size[py]){
            parent[py]=px;
            size[px]+=size[py];
        }else if(size[py]>size[px]){
            parent[px]=py;
            size[py]+=size[px];
        }else{
            parent[px]=py;
            size[py]+=size[px];
        }
        return true;
    }
}