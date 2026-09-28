class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[]ans=new int[nums.length];
        int id=0;
        TreeMap<Integer,Integer>map=new TreeMap<>();
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        while(!map.isEmpty()){
            List<Integer>list=new ArrayList<>();
            for(int val:map.keySet()){
                
                if(map.get(val)==0)list.add(val);
                else{
                    ans[id++]=val;
                    map.put(val,map.get(val)-1);
                }
            }
            for(int x:list)map.remove(x);
        }
        return ans;
    }
}