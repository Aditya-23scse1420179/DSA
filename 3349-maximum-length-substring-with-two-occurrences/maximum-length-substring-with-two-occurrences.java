class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer>map=new HashMap<>();
        int i=0,ans=0;
        for(int j=0;j<s.length();j++){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            while(map.get(s.charAt(j))>2){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}