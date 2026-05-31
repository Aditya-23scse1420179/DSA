class Solution {
    public int digitFrequencyScore(int n) {
        String s=String.valueOf(n);
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int a:s.toCharArray()){
            map.put(a-'0',map.getOrDefault(a-'0',0)+1);
        }int ans=0;
        for(int a:map.keySet()){
            ans+=(a*map.get(a));
        }
        return ans;
    }
}