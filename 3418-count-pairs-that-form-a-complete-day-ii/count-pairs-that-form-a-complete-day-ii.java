class Solution {
    public long countCompleteDayPairs(int[] hours) {
        HashMap<Integer,Integer>map=new HashMap<>();
        long count=0;
        for(int a:hours){
            int d=(24-a%24)%24;
            if(map.containsKey(d)){
                count+=map.get(d);
            }
            map.put(a%24,map.getOrDefault(a%24,0)+1);
        }
        return count;
    }
}