class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0,sum=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int num:nums){
            sum+=num;
            int prod=((sum%k)+k)%k;
            if(map.containsKey(prod)){
                count+=map.get(prod);
            }
            map.put(prod,map.getOrDefault(prod,0)+1);
        }
        return count;
    }
}