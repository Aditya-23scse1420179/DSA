class Solution {
    public long countPairs(int[] nums, int k) {
        long res=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int a:nums){
            int gcd=gcd(a,k);
            for(int key:map.keySet()){
                if((long)gcd*key%k==0)res+=map.get(key);
            }
            map.put(gcd,map.getOrDefault(gcd,0)+1);
        }
        return res;
    }public int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}