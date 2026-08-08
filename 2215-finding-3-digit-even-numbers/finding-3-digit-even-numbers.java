class Solution {
    public int[] findEvenNumbers(int[] digit) {
        int n=digit.length;
        List<Integer>list=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int a:digit){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(int i=100;i<999;i+=2){
            int d=i;
            int c=d%10;
            d/=10;
            int b=d%10;
            d/=10;
            int a=d;
            if(map.containsKey(a)){
                int fa=map.get(a);
                map.put(a,map.getOrDefault(a,0)-1);
                if(fa==1)map.remove(a);
                if(map.containsKey(b)){
                    int fb=map.get(b);
                    map.put(b,map.getOrDefault(b,0)-1);
                    if(fb==1)map.remove(b);
                    if(map.containsKey(c)){
                        // int fc=map.get(c);
                        // map.put(c,map.getOrDefault(c,0)-1);
                        // if(fc==1)map.remove(c);
                        list.add(i);
                    }
                    map.put(b,fb);
                }
                map.put(a,fa);
            }
        }
        int[]ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
        
    }
}