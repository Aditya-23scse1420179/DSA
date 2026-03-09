class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char m:magazine.toCharArray()){
            map.put(m,map.getOrDefault(m,0)+1);
        }
        for(char get:ransomNote.toCharArray()){
            if(map.getOrDefault(get,0)>=1){
                map.put(get,map.get(get)-1);
            }else return false;
        }
        return true;
    }
}