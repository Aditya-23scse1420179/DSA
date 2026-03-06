class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int ans=-1;
        for(Map.Entry<Integer,Integer>m:map.entrySet()){
            int num=m.getKey();
            int num1=m.getValue();
            if(num==num1){
                ans=Math.max(ans,num);
            }
        }
        return ans;
    }
}