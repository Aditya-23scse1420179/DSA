class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer>map=new HashMap<>();
        int count=0;
        for(int a:time){
            int dif=(60-a%60)%60;
            if(map.containsKey(dif)){
                count+=map.get(dif);
            }
            map.put(a%60,map.getOrDefault(a%60,0)+1);
        }
        return count;
    }
}