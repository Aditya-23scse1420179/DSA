class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0,sum=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int x:nums){
            sum+=x;
            int prod=((sum%k)+k)%k;
            count+=map.getOrDefault(prod,0);
            map.put(prod,map.getOrDefault(prod,0)+1);
        }
        return count;
    }
}