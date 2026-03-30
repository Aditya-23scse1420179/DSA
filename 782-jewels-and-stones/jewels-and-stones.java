class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int n=jewels.length();
        HashMap<Character,Integer>map=new HashMap<>();
        for(char a:stones.toCharArray()){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(jewels.charAt(i))){
                count+=map.get(jewels.charAt(i));
            }
        }
        return count;
    }
}