class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Integer>map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char c:t.toCharArray()){
            if(!map.containsKey(c))return false;
            map.put(c,map.get(c)-1);
            if(map.get(c)<0)return false;
        }
        return true;
    }
}